package view;

import java.util.List;
import java.util.Scanner;

import controller.GalleryPieceHelper;
import model.GalleryPiece;

public class StartGalleryProgram {

	static Scanner in = new Scanner(System.in);
	static GalleryPieceHelper gph = new GalleryPieceHelper();

	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the gallery piece title: ");
		String title = in.nextLine();
		System.out.print("Enter the artist's name: ");
		String artistName = in.nextLine();
		System.out.print("Enter the media type: ");
		String mediaType = in.nextLine();
		System.out.print("Enter the year created: ");
		String year = in.nextLine();
		System.out.print("Enter the value of the piece: ");
		double value = in.nextDouble();

		GalleryPiece toAdd = new GalleryPiece(title, artistName, mediaType, year, value);
		gph.insertItem(toAdd);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to the awesome gallery project! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Enter a new gallery piece");
			System.out.println("*  2 -- Delete a gallery piece");
			System.out.println("*  3 -- View all gallery pieces");
			System.out.println("*  4 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				deleteAnItem();
			} else if (selection == 3) {
				viewTheList();
			} else {
				gph.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}
	}

	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the title of the gallery piece to delete: ");
		String title = in.nextLine();
		System.out.print("Enter the artist of the gallery piece to delete: ");
		String artist = in.nextLine();

		GalleryPiece toDelete = new GalleryPiece(title, artist);
		gph.deleteItem(toDelete);

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<GalleryPiece> allItems = gph.showAllItems();
		for (GalleryPiece gp : allItems) {
			System.out.println(gp.returnGalleryPieceDetails());
		}
	}
}