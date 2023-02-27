package app.patronuscontrol.service;

import app.patronuscontrol.entity.DeviceEntity;
import app.patronuscontrol.entity.object.raycasting.PointEntity;
import app.patronuscontrol.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RayCastingService {

    public static final float FOV = 30;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private PointRepository pointRepository;


    public Optional<DeviceEntity> searchDevice(PointEntity userPostion, double userAng) {
        List<PointEntity> pointEntities = pointRepository.findAll();
        for (double ang = 0; ang < FOV/2    ; ang += 0.5) {
            Optional<PointEntity> optionalPointEntity = computeIntersectionPoint(userPostion, userAng + ang, pointEntities);
            if (optionalPointEntity.isPresent()) {
                PointEntity pointEntity = optionalPointEntity.get();
                return deviceService.findByPointEntity(pointEntity);
            }
            optionalPointEntity = computeIntersectionPoint(userPostion, userAng - ang, pointEntities);
            if (optionalPointEntity.isPresent()) {
                PointEntity pointEntity = optionalPointEntity.get();
                return deviceService.findByPointEntity(pointEntity);
            }
        }
        return Optional.empty();
    }

    Optional<PointEntity> pointIsInList(int x, int y, List<PointEntity> list) {
        Optional<PointEntity> optionalPointEntity = Optional.empty();
        for (PointEntity pointEntity :list) {
		    if(pointEntity.getX() == x && pointEntity.getY() == y) {
                optionalPointEntity = Optional.of(pointEntity);
            }
        }

        return optionalPointEntity;
    }

    public Optional<PointEntity> computeIntersectionPoint(PointEntity point, double ang, List<PointEntity> list){
        double xDirection = Math.cos(Math.toRadians(ang));
        double yDirection = Math.sin(Math.toRadians(ang));
        double dx, dy;
        double i = 0;
        Optional<PointEntity> optionalPointEntity;
        do {
            dx = point.getX() + i * xDirection;
            dy = point.getY() + i * yDirection;
            i += 0.5;
            optionalPointEntity = pointIsInList((int) dx, (int) dy, list);
        } while (optionalPointEntity.isEmpty() && i < 50);
        return optionalPointEntity;
    }


}
