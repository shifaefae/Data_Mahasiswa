
package Kelas;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.*;
/**
 *
 * @author LENOVO
 */
public class Mahasiswa {
    String token = "ufb2a73ed1e2bae2403ea3b3e9b5eb86ed6fdb66b49";
    String query;
    private static JSONArray datamhs;
    private static int baris;

    public static int getBaris() {
        return baris;
    }

    public static void setBaris(int baris) {
        Mahasiswa.baris = baris;
    }

    public static JSONArray getDatamhs() {
        return datamhs;
    }

    public static void setDatamhs(JSONArray datamhs) {
        Mahasiswa.datamhs = datamhs;
    }

    public JSONObject getMahasiswa() {
        query = "select * from t_mhs where  angkatan = 2021 and deleted = 0 limit 200";
        HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
                .header("Content-Type", "application/json")
                .header("Cookie", "siakaditm1=9tfsg2disjg57fk6jvn2ut7g0a")
                .body("{\"token\" : \"" + token + "\",\r\n\"query\" : \"" + query + "\"}")
                .asString();

        String jsonResponse = response.getBody();
        JSONObject obj = new JSONObject(jsonResponse);
        return obj;
    }
}
