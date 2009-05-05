package com.sampullara.locrest;

import com.mysql.jdbc.Driver;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import java.util.Properties;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Path("/iplocation")
public class IPLocation {
  @GET
  @Produces("application/json")
  @Path("/{ip}")
  public Result getLocation(@PathParam("ip") String ip) throws SQLException {
    Properties p = new Properties();
    p.put("user", "sam");
    p.put("password", "");
    Connection conn = new Driver().connect("jdbc:mysql://localhost/iploc", p);
    PreparedStatement ps = conn.prepareStatement(
            "SELECT country_code, region_code, city, zipcode, latitude, longitude " +
                    "FROM `ip_group_city` " +
                    "WHERE `ip_start` <= INET_ATON(?) " +
                    "ORDER BY ip_start " +
                    "DESC LIMIT 1");
    ps.setString(1, ip);
    ResultSet rs = ps.executeQuery();
    Result result = new Result();
    if (rs.next()) {
      result.country = rs.getString(1);
      result.region = rs.getString(2);
      result.city = rs.getString(3);
      result.zipcode = rs.getString(4);
      result.latitude = rs.getDouble(5);
      result.longitude = rs.getDouble(6);
    }
    return result;
  }
}
