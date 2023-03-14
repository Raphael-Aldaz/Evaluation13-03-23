
import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.Entities.Formation;
import fr.fms.Entities.User;
import fr.fms.Job.Joblmpl;
import fr.fms.authentification.Authentification;
import frm.fms.Dao.DaoFormations;
import frm.fms.Dao.DaoUser;

public class App {
	private static DaoFormations formationDao = new DaoFormations();
	private static Joblmpl job = new Joblmpl(); 
	private static DaoUser userDao = new DaoUser();
	private static Authentification auth = new Authentification();
	private static int userStatus = 0;
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
	
	try  {
		System.out.println("Bienvenue dans notre école ! Voici les formations disponnible !");
		formationDao.readAll().forEach(System.out::println);
		 int choice =0;
		 
		 while(choice != 10) {
			 displayMainMenu();
			 while(!scan.hasNextInt()) scan.next();
			choice =  scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Quelle catégorie voulez vous voire ? \n"
						+"1- Developpement Web \n"
						+"2- Web Design \n" 
						+"3- Sys Admin \n"
						+"4- Bureautique"
						
						);
				int choiceCat = scan.nextInt();
					displayAllFormations(formationDao.readAllByCategory(choiceCat)); 
				break;
				
			case 2 :
				displayAllFormations(formationDao.readAllByStatus(2)); 
			break;
			case 3 :
				displayAllFormations( formationDao.readAllByStatus(3));
				break;
			case 4 :
				System.out.println("Choisissez le mot clé");
				String keyWord = scan.next();
				displayAllFormations(formationDao.readAllByKeyWord(keyWord)); 
				break;
			case 5:
				System.out.println("Selectionner l'id de la formation a ajouter");
				int formationToAdd = scan.nextInt();
				Formation formation = formationDao.read(formationToAdd);
				if(formation != null) {
					job.addFormation(formation);
				} else {
					System.out.println("The formation doesn't exist !");
				}
				break;
			case 6 :
				System.out.println("Quelle formation souhaitez vous supprimer de votre panier ?");
				int formationToRemove = scan.nextInt();
				job.removeFormation(formationToRemove);
				break;
			case 7 :
				job.getOrderList().forEach(x -> System.out.println(x.getIdFormation() + "--- " + x.getNameFormation() + " ---" + x.getDescriptionFormation()+ " ----" + x.getQuantity() + " ---" + x.getPriceFormation()));
				break;
			case 8: 
				if(userStatus ==0 ) {
					System.out.println("Pour valider votre panier vous de vez vous connecter \n"
							+"1- Connectez vous : \n"
							+"2- Creation d'un compte \n");
					int connexion = scan.nextInt();
					if(connexion == 1) {
						connection();
					} else {
						
							System.out.println("Saississez votre login");
							String newUserLog = scan.next();
							System.out.println("Saisissez votre mot de passe");
							String newUserPwd = scan.next();
							if(auth.existLogin(newUserLog)) { 
								System.out.println("Sorry this user already exist");
							}else {
								job.newUser(newUserLog, newUserPwd);
								System.out.println("Utilisateur créé");
							}
					}
			} else {
				System.out.println();
			}
				break;
			case 9:
				connection();
			}
		 }
	} catch(Exception e){
		e.printStackTrace();
	}
		
	}
	
	public static void displayMainMenu() {
		System.out.println("Que voulez vous faire ? Entrez le numéro correspondant : \n \n"
				+"1- Trier par catégories \n \n"
				+"2- Afficher les formations a distance \n \n"
				+"3- Afficher les formation en présentiel \n \n"
				+"4- Chercher par mot clé \n \n"
				+"5- Ajouter une formation a mon panier \r \n"
				+"6- Supprimer un élément de mon panier \n \n"
				+"7- Afficher mon panier \n \n"
				+"8- Valider mon panier \n \n"
				);
	}
	
	public static  void displayAllFormations(ArrayList<Formation> list) {
		list.forEach(x -> System.out.println( x.getIdFormation() 
				+ "----" + x.getNameFormation() 
				+ "----" +  x.getDescriptionFormation() 
				+ "---" + x.getDurationFormation()
				+ "----" + x.getStatusFormation() 
				+ "---" + x.getPriceFormation() +"€ \n"));
	}
	
	public static void connection() {
		System.out.println("saisissez votre login : ");
		String log = scan.next();
		System.out.println("saisissez votre password : ");
		String pwd = scan.next();
		
		int id = auth.existUser(log,pwd);
		if(id > 0)	{
			
			userStatus = id;
			User a = userDao.read(userStatus);
			System.out.println("Bonjour "+ a.getLoginUser() + " !");
		}
		else {
			System.out.println("login ou password incorrect");
		}
	}

	



}
