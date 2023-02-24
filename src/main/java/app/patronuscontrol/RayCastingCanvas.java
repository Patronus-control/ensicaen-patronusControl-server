package app.patronuscontrol;

import app.patronuscontrol.entity.object.raycasting.PointEntity;
import app.patronuscontrol.service.RayCastingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;

@Service
public class RayCastingCanvas extends Canvas {


    public static PointEntity userPosition = new PointEntity(RayCastingService.GRIDSIZE / 2 + 10, RayCastingService.GRIDSIZE / 2 + 10);
    static double userAngle = 10;
    @Autowired
    private RayCastingService rayCastingService;
    private PointEntity beaconPosition = new PointEntity(RayCastingService.GRIDSIZE / 2, RayCastingService.GRIDSIZE / 2);

    public static ArrayList<PointEntity> deviceList = new ArrayList<>();
    public static ArrayList<PointEntity> rayList = new ArrayList<>();

    public void paint(Graphics g) {
        setBackground(Color.WHITE);
        drawGrid(g);
        drawUserBeaconLink(g);
        drawBeacon(g);
        drawUser(g);
        drawRay(g);
        drawDevice(g);
    }

    private void drawDevice(Graphics g) {
        g.setColor(Color.magenta);
        for(PointEntity pointEntity : deviceList) {
            g.fillOval((int) pointEntity.getX() * RayCastingService.TILESIZE, (int) pointEntity.getY() * RayCastingService.TILESIZE, RayCastingService.TILESIZE, RayCastingService.TILESIZE);
        }

    }

    void drawRay(Graphics g) {
        g.setColor(Color.GREEN);
        for (PointEntity pointEntity : rayList) {
            g.drawLine((int) userPosition.getX() * RayCastingService.TILESIZE + RayCastingService.TILESIZE / 2, (int) userPosition.getY() * RayCastingService.TILESIZE + RayCastingService.TILESIZE / 2, (int) pointEntity.getX() * RayCastingService.TILESIZE + RayCastingService.TILESIZE / 2, (int) pointEntity.getY() * RayCastingService.TILESIZE + RayCastingService.TILESIZE / 2);
        }
    }


    void drawUser(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval((int) userPosition.getX() * RayCastingService.TILESIZE, (int) userPosition.getY() * RayCastingService.TILESIZE, RayCastingService.TILESIZE, RayCastingService.TILESIZE);
    }

    void drawBeacon(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval((int) beaconPosition.getX() * RayCastingService.TILESIZE, (int) beaconPosition.getY() * RayCastingService.TILESIZE, RayCastingService.TILESIZE, RayCastingService.TILESIZE);
    }

    void drawUserBeaconLink(Graphics g) {
        g.setColor(Color.gray);
        g.drawLine((int) userPosition.getX() * RayCastingService.TILESIZE + RayCastingService.TILESIZE / 2, (int) userPosition.getY() * RayCastingService.TILESIZE + RayCastingService.TILESIZE / 2, (int) beaconPosition.getX() * RayCastingService.TILESIZE + RayCastingService.TILESIZE / 2, (int) beaconPosition.getY() * RayCastingService.TILESIZE + RayCastingService.TILESIZE / 2);
    }

    void drawGrid(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < RayCastingService.GRIDSIZE; i++) {
            for (int j = 0; j < RayCastingService.GRIDSIZE; j++) {
                g.drawRect(i * RayCastingService.TILESIZE, j * RayCastingService.TILESIZE, RayCastingService.TILESIZE, RayCastingService.TILESIZE);
            }
        }
    }


}
