package com.eatopian.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.eatopian.entity.Address;
import com.eatopian.entity.GeoHash;
import com.eatopian.entity.Restaurant;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.LatLng;

public class MysqlImplDAO implements MysqlDAO {

	private DataSource dataSource;

	public MysqlImplDAO() {

	}

	public void insert(Restaurant restaurant) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO restaurant "
				+ "(geoCode, rName, address, lng, lat) VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, restaurant.getrGeoHash().getHash());
			ps.setString(2, restaurant.getrName());
			ps.setString(3, restaurant.getAddress().getFormattedAddress());
			ps.setDouble(4, restaurant.getrLatLng().getLng().doubleValue());
			ps.setDouble(5, restaurant.getrLatLng().getLat().doubleValue());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public ArrayList<Restaurant> findNearRestaurant(Address address, int precision) {
		// TODO Auto-generated method stub
		ArrayList<Restaurant> result = new ArrayList<Restaurant>();

		LatLng location = this.getLatLng(address);

		GeoHash locationGeoHash = GeoHash.withCharacterPrecision(location
				.getLat().doubleValue(), location.getLng().doubleValue(), 10);

		String precisionGeoHashValue = locationGeoHash.getHash().substring(0,
				precision);

		System.out.println(precisionGeoHashValue);

		String sql = "SELECT rName, lat, lng FROM restaurant WHERE geoCode like '"+ precisionGeoHashValue +"%'";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, precisionGeoHashValue);

			// Customer customer = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Restaurant rt = new Restaurant();
				
				rt.setrName(rs.getString("rName"));
				rt.setLat(rs.getDouble("lat"));
				rt.setLng(rs.getDouble("lng"));
				double dis = this.distFrom(rt.getLat(), rt.getLng(), location
						.getLat().doubleValue(), location.getLng().doubleValue());
				rt.setDistance(dis);
				result.add(rt);
				
				
				// rs.getInt("CUST_ID"),
				// rs.getString("NAME"), rs.getInt("Age"));
			}
			rs.close();
			ps.close();
			// return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return result;
	}

	private LatLng getLatLng(Address address) {
		Geocoder geocoder = new Geocoder();
		LatLng rLatLng = null;
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder()
				.setAddress(address.getFormattedAddress()).getGeocoderRequest();
		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		for (GeocoderResult gr : geocoderResponse.getResults()) {
			rLatLng = gr.getGeometry().getLocation();
			break;
		}
		return rLatLng;
	}

	private double distFrom(double lat1, double lng1, double lat2, double lng2) {
		double earthRadius = 3958.75;
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
				* Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2));
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double dist = earthRadius * c;

		return dist;
	}

}
