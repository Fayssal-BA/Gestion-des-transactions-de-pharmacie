
package Application;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class Dbase {
	private static List<Document> sells = new ArrayList<Document>();
	private static List<Document> searchByCode = new ArrayList<Document>();

	// add médicament

	public static boolean ADD(String codeClient, String code, String Nom, String Prix, String QTE, String Total,
			String Payer, String Reste) {
		try (MongoClient mongo = new MongoClient("localhost", 27017)) {
			MongoDatabase dbase = mongo.getDatabase("GestionPharmacie");

			MongoCollection<Document> medecinesCollection = dbase.getCollection("Medecines");
			MongoCollection<Document> clientsCollection = dbase.getCollection("Clients");

			if (!code.equals("") && !Nom.equals("") && !Prix.equals("") && !QTE.equals("") && !Total.equals("")
					&& !Payer.equals("") && !Reste.equals("") && !codeClient.equals("")) {

				// Retrieve the client information from the database using the codeClient
				Document clientDocument = clientsCollection.find(Filters.eq("codeClient", codeClient)).first();

				if (clientDocument != null) {
					// Create a new transaction document with both client and transaction
					// information
					Document transactionDocument = new Document("Code", code)
							.append("Nom", Nom).append("Prix", Prix).append("QTE", QTE).append("Total", Total)
							.append("Payer", Payer).append("Reste", Reste).append("ClientInfo", clientDocument);

					// Insert the transaction document into the Medecines collection
					medecinesCollection.insertOne(transactionDocument);
					mongo.close();
					return true;
				} else {
					System.out.println("Client not found");
					return false;
				}
			} else {
				System.out.println("Invalid input parameters");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public static boolean ajouter(String codeClient , String prenom, String nom, String phone, String adresse) {
		try (MongoClient mongo = new MongoClient("localhost", 27017)) {
			MongoDatabase dbase = mongo.getDatabase("GestionPharmacie");

			MongoCollection<Document> collection = dbase.getCollection("Clients");
			if (!codeClient.equals("") && !prenom.equals("") && !nom.equals("") && !phone.equals("")
					&& !adresse.equals("")) {
				Document document = new Document("codeClient", codeClient).append("Prénom", prenom).append("Nom", nom)

						.append("Phone", phone).append("Adresse", adresse);
				collection.insertOne(document);
				mongo.close();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	// MODIFY MEDICAMENT

	public static boolean Modify(String code, String Nom, String Prix, String QTE, String Total, String Payer,
			String Reste , String codeclient) {
		try {

			MongoClient mongo = new MongoClient("localhost", 27017);

			MongoDatabase dbase = mongo.getDatabase("GestionPharmacie");

			MongoCollection<Document> collection = dbase.getCollection("Medecines");

			MongoCollection<Document> clientsCollection = dbase.getCollection("Clients");
			
			
			Document newClient  = clientsCollection.find(Filters.eq("codeClient", codeclient)).first();
			
			if (!Nom.equals("") && !Prix.equals("") && !QTE.equals("") && !Total.equals("") && !Payer.equals("")
					&& !Reste.equals("")) {
				Document filter = new Document("Code", code);
				Document Update = new Document("$set", new Document("Nom", Nom).append("Prix", Prix).append("QTE", QTE)
						.append("Total", Total).append("Payer", Payer).append("Reste", Reste).append("ClientInfo",newClient));

				collection.updateOne(filter, Update);
				mongo.close();
				return true;
			}

			else {
				mongo.close();
				return false;
			}

		}

		catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	// MODIFY CLIENT

	public static boolean modifie(String codeClient ,String prenom, String nom, String phone, String adresse) {
		try {

			MongoClient mongo = new MongoClient("localhost", 27017);

			MongoDatabase dbase = mongo.getDatabase("GestionPharmacie");

			MongoCollection<Document> collection = dbase.getCollection("Clients");

			if (!codeClient.equals("") && !prenom.equals("") && !nom.equals("") && !phone.equals("") && !adresse.equals("")) {
				Document filter = new Document("codeClient", codeClient);
				Document Update = new Document("$set",
						new Document("Prénom" , prenom).append("Nom", nom).append("Phone", phone).append("Adresse", adresse));

				collection.updateOne(filter, Update);
				mongo.close();
				return true;
			}

			else {
				mongo.close();
				return false;
			}

		}

		catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	// DELETE MEDICAMENT
	public static boolean Delete(String code) {
		try {

			MongoClient mongo = new MongoClient("localhost", 27017);

			MongoDatabase dbase = mongo.getDatabase("GestionPharmacie");

			MongoCollection<Document> collection = dbase.getCollection("Medecines");
			Document filter = new Document("Code", code);
			collection.deleteOne(filter);
			mongo.close();
			return true;
		}

		catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	// DELETE CLIENT
	public static boolean supprimer(String codeClient) {
		try {

			MongoClient mongo = new MongoClient("localhost", 27017);

			MongoDatabase dbase = mongo.getDatabase("GestionPharmacie");

			MongoCollection<Document> collection = dbase.getCollection("Clients");
			Document filter = new Document("codeClient", codeClient);
			collection.deleteOne(filter);
			mongo.close();
			return true;
		}

		catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	// getsells des medicaments

	public static List<Document> getSells() {

		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoDatabase dbase = mongo.getDatabase("GestionPharmacie");

		MongoCollection<Document> collection = dbase.getCollection("Medecines");
		MongoCursor<Document> cursor = collection.find().iterator();
		sells.clear();
		try {
			while (cursor.hasNext()) {
				Document Document = cursor.next();
				sells.add(Document);
			}
		} finally {
			mongo.close();
		}

		return sells;

	}

	// getsells des CLIANTS

	public static List<Document> getSellsClients() {

		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoDatabase dbase = mongo.getDatabase("GestionPharmacie");

		MongoCollection<Document> collection = dbase.getCollection("Clients");
		MongoCursor<Document> cursor = collection.find().iterator();
		sells.clear();
		try {
			while (cursor.hasNext()) {
				Document Document = cursor.next();
				sells.add(Document);
			}
		} finally {
			mongo.close();
		}

		return sells;

	}
	//////////////////////////////////:
	
	
	///////////////////////////////

	public static Document getOne(String code) {

		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoDatabase dbase = mongo.getDatabase("GestionPharmacie");

		MongoCollection<Document> collection = dbase.getCollection("Medecines");

		Document filter = new Document("Code", code);
		searchByCode.clear();
		try {
			MongoCursor<Document> cursor = collection.find(filter).iterator();
			while (cursor.hasNext()) {
				searchByCode.add(cursor.next());
			}
			return searchByCode.isEmpty() ? null : searchByCode.get(0);

		} catch (Exception e) {

			return null;
		}

	}

}
