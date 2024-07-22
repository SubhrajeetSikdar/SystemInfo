import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class IPLocationTracer {

    private static final String API_KEY = "YOUR_API_KEY";  // Replace with your ipstack API key

    public static void main(String[] args) {
        String ip = "134.201.250.155";  // Example IP address
        try {
            String location = getIPLocation(ip);
            System.out.println(location);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getIPLocation(String ip) throws Exception {
        String url = "http://api.ipstack.com/" + ip + "?access_key=" + API_KEY;
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        connection.disconnect();

        JSONObject json = new JSONObject(content.toString());
        String city = json.getString("city");
        String region = json.getString("region_name");
        String country = json.getString("country_name");

        return "City: " + city + ", Region: " + region + ", Country: " + country;
    }
}
