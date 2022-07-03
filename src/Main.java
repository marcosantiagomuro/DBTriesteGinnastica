import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connect = MyJDBC.connectionToDatabase();
        ResultSet ResSet = null;
        int scelta;
        System.out.println("Inserire il numero della richiesta che si vuole eseguire:\n" +
                "1: Visualizza le lezioni di oggi\n" +
                "2: Elimino un corso\n" +
                "3: Visualizza gli atleti iscritti ad un determinato corso\n" +
                "4: Visualizza le informazioni di un atleta\n"+
                "5: Verifico le scadenze dei Certificati Medici\n"+
                "6: Ottengo i dati dei miei dipendenti per gli stipendi \n"+
                "7: Verifico la scadenza del pagamento unico\n"+
                "8: Finanza: controllo le entrate degli atleti\n"+
                "9: Finanza: controllo le uscite dei dipendenti \n"+
                "10: Finanza: controllo le uscite delle palestre\n");
        scelta = scanner.nextInt();
        switch(scelta){
            case 1:
                ResSet = MyJDBC.callToSPControlloLezioniOggi(connect);
                break;

            case 2:
                ResSet = MyJDBC.callToSPEliminareCorso(connect);
                break;

            case 3:
                ResSet = MyJDBC.callToSPVisualizzaIscritti(connect);
                break;

            case 4:
                ResSet = MyJDBC.callToSPVisualizzaAtleta(connect);
                break;

            case 5:
                ResSet = MyJDBC.callToSPAvvisoScadenzaCM(connect);
                break;

            case 6:
                ResSet = MyJDBC.callToSPPagareDipendenti(connect);
                break;

            case 7:
                ResSet = MyJDBC.callToSPAvvisoPagamentoUnico(connect);
                break;

            case 8:
                ResSet = MyJDBC.callToSPControlloFinanzaEntrataAtleti(connect);
                break;

            case 9:
                ResSet = MyJDBC.callToSPControlloUsciteDipendenti(connect);
                break;

            case 10:
                ResSet = MyJDBC.callToSPControlloFinanzaUscitePalestre(connect);
                break;

            default :
                System.out.println("Valore di scelta inserito non valido");
        }

        try {
            ResultSetMetaData ResSetMetData = ResSet.getMetaData();
            int columnsNumber = ResSetMetData.getColumnCount();
            while (ResSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(", \t");
                    String columnValue = ResSet.getString(i);
                    System.out.print(ResSetMetData.getColumnName(i)+ ": "+ columnValue);
                }
                System.out.println("");
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }

    }

}