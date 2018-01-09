package com.MavenGitEclipse.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.MavenGitEclipse.WebServices;
import com.MavenGitEclipse.pojo.Datanova;
import com.MavenGitEclipse.pojo.Record;

public class DataQueries {

	public static void synchronize(int rows) {
		Datanova dn = WebServices.getDatas(rows+"");

		Iterator<Record> it = dn.getRecords().iterator();

		String query = "Select code_commune_insee From data where code_commune_insee = "+it.next().getFields().getCodeCommuneInsee();

		while(it.hasNext()) {
			query = query + " OR code_commune_insee = "+it.next().getFields().getCodeCommuneInsee();
		}
		System.out.println(query);

		try {
			List<HashMap<String,Object>> result = MainQueries.select(query);

			List<Record> toUpdate = new ArrayList<Record>();
			List<Record> toInsert = new ArrayList<Record>();

			for (Record r : dn.getRecords()) {
				Boolean found = false;
				for(HashMap<String,Object> data : result) {
					if(data.get("code_commune_insee").equals(r.getFields().getCodeCommuneInsee())) {
						toUpdate.add(r);
						found = true;
					}
				}
				if(!found) {
					toInsert.add(r);
				}
			}

			updateData(toUpdate);
			insertData(toInsert);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void insertData(List<Record> toInsert) throws SQLException {
		Iterator<Record> it = toInsert.iterator();

		if(it.hasNext()) {
			Record r = it.next();
			String query = "Insert INTO data (code_commune_insee, nom_de_la_commune, libell_d_acheminement, code_postal, lattitude, longitude) "
					+ "VALUES ('"+r.getFields().getCodeCommuneInsee()+"','"
					+r.getFields().getNomDeLaCommune()+"','"
					+r.getFields().getLibellDAcheminement()+"','"
					+r.getFields().getCodePostal()+"','"
					+r.getFields().getCoordonneesGps().get(0)+"','"
					+r.getFields().getCoordonneesGps().get(1)+"')";

			while(it.hasNext()) {
				r = it.next();
				query = query + ",('"+r.getFields().getCodeCommuneInsee()+"','"
						+r.getFields().getNomDeLaCommune()+"','"
						+r.getFields().getLibellDAcheminement()+"','"
						+r.getFields().getCodePostal()+"','"
						+r.getFields().getCoordonneesGps().get(0)+"','"
						+r.getFields().getCoordonneesGps().get(1)+"')";
			}
			query = query + ";";
			System.out.println(query);
			MainQueries.insert(query);
		}
	}

	/*private static void updateData(List<Record> toUpdate) throws SQLException {
		Iterator<Record> it = toUpdate.iterator();
		if(it.hasNext()) {
			Record r = it.next();
			String query = "Update data SET "
					+ "nom_de_la_commune = '"+r.getFields().getNomDeLaCommune()+"', "
					+ "libell_d_acheminement = '"+r.getFields().getLibellDAcheminement()+"', "
					+ "code_postal = '"+r.getFields().getCodePostal()+"', "
					+ "lattitude = '"+r.getFields().getCoordonneesGps().get(0)+"', "
					+ "longitude = '"+r.getFields().getCoordonneesGps().get(1)+"' "
					+ "WHERE code_commune_insee = '"+r.getFields().getCodeCommuneInsee()+"'";

			while(it.hasNext()) {
				r = it.next();
				query = query +  "; Update data SET "
						+ "nom_de_la_commune = '"+r.getFields().getNomDeLaCommune()+"', "
						+ "libell_d_acheminement = '"+r.getFields().getLibellDAcheminement()+"', "
						+ "code_postal = '"+r.getFields().getCodePostal()+"', "
						+ "lattitude = '"+r.getFields().getCoordonneesGps().get(0)+"', "
						+ "longitude = '"+r.getFields().getCoordonneesGps().get(1)+"' "
						+ "WHERE code_commune_insee = '"+r.getFields().getCodeCommuneInsee()+"'";
			}
			System.out.println(query);
			MainQueries.update(query);
		}
	}*/

	private static void updateData(List<Record> toUpdate) throws SQLException {
		Iterator<Record> it = toUpdate.iterator();

		while(it.hasNext()) {
			Record r = it.next();
			String query = "Update data SET "
					+ "nom_de_la_commune = '"+r.getFields().getNomDeLaCommune()+"', "
					+ "libell_d_acheminement = '"+r.getFields().getLibellDAcheminement()+"', "
					+ "code_postal = '"+r.getFields().getCodePostal()+"', "
					+ "lattitude = '"+r.getFields().getCoordonneesGps().get(0)+"', "
					+ "longitude = '"+r.getFields().getCoordonneesGps().get(1)+"' "
					+ "WHERE code_commune_insee = '"+r.getFields().getCodeCommuneInsee()+"'";
			System.out.println(query);
			MainQueries.update(query);
		}


	}
}
