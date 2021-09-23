import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class Vehicles {

    private final String swapi = "https://swapi.dev/api/vehicles";

    private CompletableFuture<String> vehicles;

    public CompletableFuture<String> getVehicles() {
        return vehicles;
    }

    public Vehicles() {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder().uri(URI.create(swapi)).build();
        vehicles = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
//                .thenAccept(System.out::println)
//                .join();
    }
}
