package testapplication;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 import com.teamdev.jxmaps.swing.MapView;
 import com.teamdev.jxmaps.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
/*import java.awt.BorderLayout;
import javafx.scene.layout.Border;
import javax.swing.JFrame;*/
/**
 *
 * @author Ismail
 */
 
public class Mapa extends MapView {

    private Map map;
    public Mapa(String nName , double aa, double bb){
        JFrame frame = new JFrame(nName);
        setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
               
                if(status == MapStatus.MAP_STATUS_OK)
                {
                    map = getMap();
                    MapOptions mapOptions = new MapOptions();
                    MapTypeControlOptions controlOptions = new MapTypeControlOptions();
                    mapOptions.setMapTypeControlOptions(controlOptions);
                    map.setOptions(mapOptions);
                    map.setCenter(new LatLng(aa,bb));
                    map.setZoom(11.0);
                    
                    Marker mark = new Marker(map);
                    mark.setPosition(map.getCenter());
                    
                    Circle circle = new Circle(map);
                    circle.setCenter(map.getCenter());
                    circle.setRadius(300);
                    
                    CircleOptions co = new CircleOptions();
                    co.setFillColor("#FF0000");
                    co.setFillOpacity(0.35);
                    
                    circle.setOptions(co);
                    
                }
            }
        });
       
            
                
       
      
        frame.add(this,BorderLayout.CENTER);
        frame.setSize(700,500);
        frame.setVisible(true);
        
        
    }
    public static void main(String[] args){
        Mapa temp = new Mapa("maps",36.702269,10.244232);
    }
}
