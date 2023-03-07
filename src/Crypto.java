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

    public static int[] frequences( final String pFile )
    {
        String vTxt = readFile(pFile);
        vTxt = vTxt.toUpperCase();

        /* Tableau de frequences (vOcc[k]:Nbr d'occurrences de la k-ieme
           lettre de l'alphabet dans la chaine vTxt) */
        int[] vOcc= new int[26];
        //========== TODO Question-1


        //========== Fin TODO Question-1
        return vOcc;
    } // frequences()


    /**
     * D�chiffrer le contenu d'un fichier en appliquant une substitution
     * mono-alphab�tique bas�e sur une table de correspondance de lettres
     */

    public static String subDecrypt( final String pFile, final char[] pKey )
    {
        String vChiffre = readFile(pFile);
        vChiffre = vChiffre.toUpperCase();
        String vClair = "";
        //=========== TODO Question-3


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

        //=========== Fin TODO Question-5
    } // ecbXor()


    /*=============== Tests et invocations de m�thodes ============================*/

    public static void main( final String[] pArgs )
    {


        //TODO Question-3

        //Fin TODO Question-3

        /*=============================================================*/

        //TODO Question-4

        //Fin TODO Question-4

        /*=============================================================*/

        //TODO Question-6

        //Fin TODO Question-6

        /*=============================================================*/

        //TODO Question-8

        //Fin TODO Question-8

    } // main()
} // Crypto
