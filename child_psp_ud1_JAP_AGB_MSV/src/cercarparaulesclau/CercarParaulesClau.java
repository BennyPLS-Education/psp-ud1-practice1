package cercarparaulesclau;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/***
 * ECNUNCIAT:
 *      El procés fill ha de sol·licitar una paraula que és vulgui cercar, donada aquesta
 *      paraula, el procés fill ha de cercar si existeix o no la paraula almenys un cop dins el
 *      codi.
 *
 * PROTOCOL:
 *      1.
 *
 *
 */

public class CercarParaulesClau {
    public static void main(String[] args) throws Exception {
        var in = new BufferedReader(new InputStreamReader(System.in));

        var word = in.readLine();
        var hasWord = String.join("", in.lines().toList()).contains(word);

        if (hasWord)
            System.out.println();
        else
            System.out.println();
    }
}
