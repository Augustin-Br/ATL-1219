import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Crypto
{
    //===========================================================
    //                METHODES UTILES
    //===========================================================

    /**
     * Convertir une chaine de caracteres en tableau de bytes
     */
    public static byte[] strToByte( final String pMsg )
    {
        return pMsg.getBytes();
    } // strToByte

    /**
     * Convertir un tableau de bytes en une chaine de caracteres
     */
    public static String byteToStr( final byte[] pByteArray )
    {
        return new String(pByteArray);
    } // byteToStr()

    /**
     * Ecrire un texte dans un fichier en conservant son contenu
     * si "pAjout=true", ou en l'ecrasant si "pAjout=false"
     */
    public static void writeFile( final String pContent, final String pFile, final boolean pAjout )
    {
        try {
            FileWriter vWriter = new FileWriter(pFile, pAjout);
            vWriter.write(pContent);
            vWriter.close();
        }
        catch( final IOException pE ) {
            pE.printStackTrace();
        }
    } // writeFile()

    /**
     * Lire le contenu d'un fichier de nom (pFile)
     * et le retourner dans une String
     */
    public static String readFile( final String pFile )
    {
        String vContent = "";
        try {
            vContent = new String( Files.readAllBytes( Paths.get(pFile) ) );
        }
        catch( final IOException pE ) {
            pE.printStackTrace();
        }
        return vContent;
    } // readFile()

    //===========================================================
    //                FIN METHODES UTILES
    //===========================================================

    /**
     * Calculer le nombre d'occurence de chaque lettre dans un fichier
     * texte
     */

    public static int[] frequences( final String pFile ) {
        String vTxt = readFile(pFile); // On lit le fichier
        vTxt = vTxt.toUpperCase(); // On convertit en majuscules

        /* Tableau de frequences (vOcc[k]:Nbr d'occurrences de la k-ieme
           lettre de l'alphabet dans la chaine vTxt) */
        int[] vOcc = new int[26];
        //========== TODO Question-1

        for (int i = 0; i < vTxt.length(); i++) { // On parcourt le texte
            char c = vTxt.charAt(i); // On récupère le caractère
            if (c >= 'A' && c <= 'Z') { // Si c'est une lettre
                vOcc[c - 'A']++; // On incrémente la fréquence de la lettre
                //System.out.println(c +" : " + vOcc[c - 'A']);
            }
        }


        //========== Fin TODO Question-1

        System.out.println("Frequences des lettres dans le fichier " + pFile + ":"); // Affichage
        for (int i = 0; i < vOcc.length; i++){ // On parcourt le tableau
            System.out.print((char) ('A' + i) + " : " + vOcc[i] + ", "); // On affiche la lettre et sa fréquence
        }
        return vOcc;
    } // frequences()


    /**
     * D�chiffrer le contenu d'un fichier en appliquant une substitution
     * mono-alphab�tique bas�e sur une table de correspondance de lettres
     */

    public static String subDecrypt( final String pFile, final char[] pKey )
    {
        String vChiffre = readFile(pFile); // On lit le fichier
        vChiffre = vChiffre.toUpperCase(); // On convertit en majuscules
        String vClair = ""; // Variable qui contiendra le texte déchiffré
        //=========== TODO Question-3

        for (int i = 0; i < vChiffre.length(); i++) { // On parcourt le texte
            char c = vChiffre.charAt(i); // On récupère le caractère
            if (c >= 'A' && c <= 'Z') { // Si c'est une lettre
                vClair += pKey[c - 'A']; // On ajoute la lettre déchiffrée
            } else { // Si ce n'est pas une lettre donc un espace ou un point
                vClair += c; // On ajoute le caractère
            }
        }

        //=========== Fin TODO Question-3
        return vClair;
    } // subDecrypt()

    /**
     * Chiffrer/D�chiffrer le contenu d'un fichier en appliquant une m�thode
     * par blocs et XOR
     */

    public static void ecbXor( final String pInfile, final String pOutfile, final String pKey )
    {

        //=========== TODO Question-5

        byte[] vKey = strToByte(pKey); // On convertit la clé en tableau de bytes
        String vCont = readFile(pInfile); // On lit le fichier
        byte[] vFileCont = strToByte(vCont); // On convertit le contenu du fichier en tableau de bytes
        byte[] vFileOut = new byte[vFileCont.length]; // On crée un tableau de bytes qui contiendra le contenu du fichier chiffré
        String vRes = ""; // Variable qui contiendra le texte chiffré

        for(int i = 0; i < vFileCont.length; i++) { // On parcourt le tableau de bytes
            vFileOut[i] = (byte) (vFileCont[i] ^ vKey[i % 4]); // On applique le XOR
        }

        vRes += byteToStr(vFileOut); // On convertit le tableau de bytes en String

        writeFile(vRes, pOutfile, true); // On écrit le résultat dans le fichier de sortie

        //=========== Fin TODO Question-5
    } // ecbXor()


    /*=============== Tests et invocations de méthodes ============================*/

    public static void main( final String[] pArgs )
    {


        //TODO Question-3

        char[] vTabChar = {'V', 'K', 'Z', 'M', 'H', 'N', 'O', 'P', 'C', 'Q', 'R', 'S', 'T', 'Y', 'I', 'J', 'X', 'D', 'L', 'E', 'G', 'W', 'U', 'A', 'B', 'F'}; // tableau de correspondance
        System.out.println(subDecrypt("src/Code", vTabChar)); // On déchiffre le texte

        //Fin TODO Question-3

        /*=============================================================*/

        //TODO Question-4
        char[] vKeyDec6 = {'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'};
        System.out.println(subDecrypt("src/q4", vKeyDec6));

        //Fin TODO Question-4

        /*=============================================================*/

        //TODO Question-6

        //Fin TODO Question-6

        /*=============================================================*/

        //TODO Question-8

        //Fin TODO Question-8

    } // main()
} // Crypto
