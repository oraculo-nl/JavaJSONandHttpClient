import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.ExecutionException;

public class JSONParsing {

    public static void main(String[] args) throws ExecutionException, InterruptedException, JsonProcessingException {
        var v = new Vehicles();
        var objMapper = new ObjectMapper();
        var jsonNode = objMapper.readTree(v.getVehicles()
                .get());
        var vhs = jsonNode.get("results");
        if (vhs.isArray()) {
            //Jackson doesnt have streams, but uses Iterator
            var i = vhs.elements();
            i.forEachRemaining(o -> System.out.println(o.get("name")));

        }


    }
}
