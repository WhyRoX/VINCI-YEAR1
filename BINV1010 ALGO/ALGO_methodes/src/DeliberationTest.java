import org.junit.Assert;
import org.junit.Test;

public class DeliberationTest {

    @Test
    public void testCalculerMoyenneEtudiant() {
        double[] notes = {12.5, 15.0, 10.0, 14.0, 13.0, 16.0, 14.5, 15.5, 17.0, 18.0};
        double expected = 14.55;
        double actual = Deliberation.calculerMoyenneEtudiant(/*ajt "notes"*/);
        Assert.assertEquals(expected, actual, 0.01);
    }
    public static double calculerMoyenneEtudiant(double[] notes) {
        double sommeDesNotes = 0;
        for (double note : notes) {
            sommeDesNotes += note;
        }
        return sommeDesNotes / notes.length;
    }
}
