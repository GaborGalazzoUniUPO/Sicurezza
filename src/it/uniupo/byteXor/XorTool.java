package it.uniupo.byteXor;


import java.util.Scanner;

import it.uniupo.byteLib.Tools;

import static it.uniupo.byteXor.XOR.xorCipher;

public class XorTool {

	public static void main(String[] args) {
		
		 boolean stampoSuStdOut = true;
		 String outputFile;
		 Scanner sc = new Scanner(System.in);	
		 char tipoXOR = 'x'; // x = xor tra i due: lungh output il min tra le lunghezze

		 
		 System.out.println("\nXOR\nScegliere l'opzione che interessa:");
		 
		 System.out.println("\tx (default): XOR(argomento1, argomento2); se i due hanno lunghezza diversa, la lunghezza dell'output è il minimo\n"
		 		+ "\tc: cifraturaXOR(testo, chiave); se la chiave e' piu' corta viene usata ciclicamente"
		 		+ "\n\tq: quit");
		 String scelta = sc.nextLine();
		 if (!scelta.isEmpty()) {
			 tipoXOR = scelta.charAt(0);
		 }
		 
		 while (tipoXOR != 'q') {
		 if (tipoXOR == 'x') {
		 System.out.println("Eseguo XOR(argomento1, argomento2)");
		 } else {
			 System.out.println("Eseguo cifraturaXOR(testo,chiave)");
		 }
		 String nomeFileInserito = "";
		 
		 byte[] chiaro = null;
		 byte[] chiave = null;
		 
while(chiaro == null) {
		 System.out.println("\tDigitare il nome del file che contiene il primo argomento (il testo in caso di opzione cifrario):");
		 nomeFileInserito = sc.nextLine();
		 if (!nomeFileInserito.isEmpty()) {
		 chiaro =  Tools.readByteFlow(nomeFileInserito);
		 }
}
while(chiave == null) {
		 System.out.println("\tDigitare il nome del file che contiene il secondo argomento (la chiave in caso di opzione cifrario):");
		 nomeFileInserito = sc.nextLine();
		 if (!nomeFileInserito.isEmpty())
		chiave = Tools.readByteFlow(nomeFileInserito);

}
		 
		 System.out.println("\tSi vuole il risultato su file o su standard output? Se si vuole su stdout, premere invio; se si vuole su file, digitare il nome del file.");
		 outputFile = sc.nextLine();
		 if (!outputFile.isEmpty()) {
			 stampoSuStdOut = false;
			 System.out.println("\tScrivo il risultato sul file "+ outputFile);
		 }
		
		
		
		byte[] cifrato;
		if (tipoXOR == 'x') {
			cifrato = XOR.xor(chiaro, chiave);
		} else {
			cifrato = xorCipher(chiaro,chiave);
		}
		
		if(stampoSuStdOut == true) {
			try {
			System.out.println(Tools.byteToString(cifrato));
			} catch (Exception e) {
				System.out.println("Attenzione, la stringa contiene caratteri non stampabili: vuoi stamparla lo stesso ignorando i caratteri non stampabili? y/[n]");
				char reply = 'n';
				reply = sc.nextLine().charAt(0);
				if(reply == 'y') {
					System.out.println(Tools.byteToHexString(cifrato));
				}
				
			} 
		} else {
			Tools.writeByteFlow(cifrato, outputFile);
		}
		System.out.println("\nXOR\nScegliere l'opzione che interessa:");
		 
		 System.out.println("\tx (default): XOR(argomento1, argomento2); se i due hanno lunghezza diversa, la lunghezza dell'output è il minimo\n"
		 		+ "\tc: cifraturaXOR(testo, chiave); se la chiave e' piu' corta viene usata ciclicamente"
		 		+ "\n\tq: quit");
		 scelta = sc.nextLine();
		 if (!scelta.isEmpty()) {
			 tipoXOR = scelta.charAt(0);
		 }
		
		 }
			sc.close();
System.out.println("Bye!");
	}


}
