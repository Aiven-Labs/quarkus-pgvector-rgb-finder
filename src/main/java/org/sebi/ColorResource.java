package org.sebi;

import java.util.List;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("colors")
public class ColorResource {
    
    @POST
    public List<Color> nearestColor(String vector) {
        return Color.findNearestNeighbors(vector);
    }
}
