package st.alr.mqttitude.model;

import java.util.concurrent.TimeUnit;

import st.alr.mqttitude.db.Waypoint;

public class WaypointMessage {
    Waypoint waypoint;
    
    
    public WaypointMessage(Waypoint w){
        waypoint = w;
    }
    public String toString(){
        StringBuilder builder = new StringBuilder();
        
        builder.append("{");
        builder.append("\"_type\": ").append("\"").append("waypoint").append("\"");
        builder.append(", \"desc\": ").append("\"").append(waypoint.getDescription()).append("\"");
        builder.append(", \"lat\": ").append("\"").append(waypoint.getLatitude()).append("\"");
        builder.append(", \"lon\": ").append("\"").append(waypoint.getLongitude()).append("\"");
        builder.append(", \"tst\": ").append("\"").append((int)(TimeUnit.MILLISECONDS.toSeconds(waypoint.getDate().getTime()))).append("\"");
        builder.append(", \"rad\": ").append("\"").append(waypoint.getRadius() != null ? waypoint.getRadius() : 0).append("\"");
        
        return builder.append("}").toString();
        
            
    }
}