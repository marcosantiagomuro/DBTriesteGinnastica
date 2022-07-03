import jdk.nashorn.internal.codegen.CompilerConstants;

import java.sql.*;
import java.util.Scanner;

public class MyJDBC {

    public static Connection connectionToDatabase() {

        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/TriesteGinnastica", "root", "Swimmer46");
            return connect;
        } catch (SQLException except) {
            System.out.println(except.toString());
            return null;
        }
    }

    // 1

    public static ResultSet callToSPControlloLezioniOggi(Connection connect) {
        try {
            CallableStatement CallStatm = connect.prepareCall("{CALL sp_ControlloLezioniOggi(?)}");
            System.out.println("inserire Codice Fiscale Allenatore");
            String CFAllen = obatainString();
            CallStatm.setString(1, CFAllen);
            ResultSet resSet = CallStatm.executeQuery();
            return resSet;
        } catch (SQLException excep) {
            System.out.println(excep.toString());
            return null;
        }
    }


    // 2

    public static ResultSet callToSPEliminareCorso(Connection connect) {
        try {
            CallableStatement CallStatm = connect.prepareCall("{CALL sp_EliminareCorso(?,?)}");
            System.out.println("inserire Codice Corso");
            String cCorso = obatainString();
            CallStatm.setString(1, cCorso);
            System.out.println("inserire Anno Corso [ YYYY/YYYY ]");
            String aCorso = obatainString();
            CallStatm.setString(2, aCorso);
            ResultSet resSet = CallStatm.executeQuery();
            return resSet;
        } catch (SQLException excep) {
            System.out.println(excep.toString());
            return null;
        }
    }


    // 3

    public static ResultSet callToSPVisualizzaIscritti(Connection connect) {
        try {
            CallableStatement CallStatm = connect.prepareCall("{CALL sp_VisualizzaIscritti(?,?)}");
            System.out.println("inserire Codice Corso");
            String cCorso = obatainString();
            CallStatm.setString(1, cCorso);
            System.out.println("inserire Anno Corso [ YYYY/YYYY ]");
            String aCorso = obatainString();
            CallStatm.setString(2, aCorso);
            ResultSet resSet = CallStatm.executeQuery();
            return resSet;
        } catch (SQLException excep) {
            System.out.println(excep.toString());
            return null;
        }
    }



    // 4

    public static ResultSet callToSPVisualizzaAtleta(Connection connect) {
        try {
            CallableStatement CallStatm = connect.prepareCall("{CALL sp_VisualizzaAtleta(?)}");
            System.out.println("inserire Codice Fiscale Atleta");
            String CFAtl = obatainString();
            CallStatm.setString(1, CFAtl);
            ResultSet resSet = CallStatm.executeQuery();
            return resSet;
        } catch (SQLException excep) {
            System.out.println(excep.toString());
            return null;
        }
    }



    // 5

    public static ResultSet callToSPAvvisoScadenzaCM(Connection connect) {
        try {
            CallableStatement CallStatm = connect.prepareCall("{CALL sp_AvvisoScadenzaCM()}");
            ResultSet resSet = CallStatm.executeQuery();
            return resSet;
        } catch (SQLException excep) {
            System.out.println(excep.toString());
            return null;
        }
    }


    // 6
    public static ResultSet callToSPPagareDipendenti(Connection connect) {
        try {
            CallableStatement CallStatm = connect.prepareCall("{CALL sp_PagareDipendenti()}");
            ResultSet resSet = CallStatm.executeQuery();
            return resSet;
        } catch (SQLException excep) {
            System.out.println(excep.toString());
            return null;
        }
    }


    //  7

    public static ResultSet callToSPAvvisoPagamentoUnico(Connection connect) {
        try {
            CallableStatement CallStatm = connect.prepareCall("{CALL sp_AvvisoPagamentoUnico()}");
            ResultSet resSet = CallStatm.executeQuery();
            return resSet;
        } catch (SQLException excep) {
            System.out.println(excep.toString());
            return null;
        }
    }


    // 8.1

    public static ResultSet callToSPControlloFinanzaEntrataAtleti(Connection connect) {
        try {
            CallableStatement CallStatm = connect.prepareCall("{CALL sp_ControlloFinanzaEntrataAtleti(?)}");
            System.out.println("inserire Anno [ YYYY ]");
            int anno = getInt();
            CallStatm.setInt(1,anno);
            ResultSet resSet = CallStatm.executeQuery();
            return resSet;
        } catch (SQLException excep) {
            System.out.println(excep.toString());
            return null;
        }
    }

    // 8.2

    public static ResultSet callToSPControlloUsciteDipendenti(Connection connect) {
        try {
            CallableStatement CallStatm = connect.prepareCall("{CALL sp_ControlloFinanzaUsciteDipendenti(?)}");
            System.out.println("inserire Anno [ YYYY ]");
            int anno = getInt();
            CallStatm.setInt(1,anno);
            ResultSet resSet = CallStatm.executeQuery();
            return resSet;
        } catch (SQLException excep) {
            System.out.println(excep.toString());
            return null;
        }
    }


    // 8.3

    public static ResultSet callToSPControlloFinanzaUscitePalestre(Connection connect) {
        try {
            CallableStatement CallStatm = connect.prepareCall("{CALL sp_ControlloFinanzaUscitePalestre()}");
            ResultSet resSet = CallStatm.executeQuery();
            return resSet;
        } catch (SQLException excep) {
            System.out.println(excep.toString());
            return null;
        }
    }






















    /* ---------------------------------------------------------- */


    private static Integer getInt() {
        Scanner scan = new Scanner(System.in);
        try {
            return scan.nextInt();
        } catch (Exception ex) {
            System.out.println("Valore Non valido!");
            return null;
        }
    }

  /*  private static Integer getYear() {
        Scanner scan = new Scanner(System.in);
        try {
            return scan.next();
        } catch (Exception ex) {
            System.out.println("Valore Non valido!");
            return null;
        }
    }

   */

    private static String obatainString() {
        Scanner scan = new Scanner(System.in);
        try {
            return scan.nextLine();
        } catch (Exception ex) {
            System.out.println("Valore Non valido!");
            return null;
        }
    }

}