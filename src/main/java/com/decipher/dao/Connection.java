
package com.decipher.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

@Component
public class Connection {

	@Autowired
	MongoClient conn;

	public DBCollection getCollection() {
		DBCollection col = null;
		try {
			@SuppressWarnings("deprecation")
			DB db = conn.getDB("EMPLOYEE");
			col = db.getCollection("employee");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return col;
	}
}



