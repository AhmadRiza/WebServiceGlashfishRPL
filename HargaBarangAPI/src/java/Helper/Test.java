/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Helper;

/**
 *
 * @author Ahmad Riza
 */
public class Test {
    public static void main(String[] args) {
        DbHelper db = new DbHelper();
//        if(db.getCurrentHarga())
//            System.out.println(db.getResultJSON());
//        else
//            System.out.println(db.message);
        System.out.println(db.getCurrentHarga("DAY"));
    }

}
