import java.util.Arrays;

public class mamaa {

    private String mois;
    private double[] tableDesTemperatures;

    public mamaa(String mois, double[] tableARecopier) {
        if (tableARecopier == null)
            throw new IllegalArgumentException();
        if (tableARecopier.length == 0)
            throw new IllegalArgumentException();
        this.mois = mois;
        this.tableDesTemperatures = new double[tableARecopier.length];
        for (int i = 0; i < tableARecopier.length; i++) {
            this.tableDesTemperatures[i] = tableARecopier[i];
        }
    }

    public String toString() {
        String aRenvoyer = "temperatures du mois de " + this.mois + " : \n";
        return aRenvoyer + Arrays.toString(tableDesTemperatures);
    }

    public double moyenne() {
        double somme = 0;
        for (double temperature : tableDesTemperatures) {
            somme += temperature;
        }
        return somme / tableDesTemperatures.length;
    }

    public double temperatureMin() {
        double min = tableDesTemperatures[0];
        for (double temperature : tableDesTemperatures) {
            if (temperature < min) {
                min = temperature;
            }
        }
        return min;
    }

    public int nombreJoursDeGel() {
        int count = 0;
        for (double temperature : tableDesTemperatures) {
            if (temperature < 0) {
                count++;
            }
        }
        return count;
    }

    public int[] joursDeGel() {
        int count = 0;
        for (double temperature : tableDesTemperatures) {
            if (temperature < 0) {
                count++;
            }
        }
        int[] joursDeGelArray = new int[count];
        int index = 0;
        for (int i = 0; i < tableDesTemperatures.length; i++) {
            if (tableDesTemperatures[i] < 0) {
                joursDeGelArray[index] = i;
                index++;
            }
        }
        return joursDeGelArray;
    }

    public boolean toutesPositives() {
        for (double temperature : tableDesTemperatures) {
            if (temperature < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean contientAuMoinsUnJourDeGel() {
        return !toutesPositives();
    }

    public boolean contientAuMoinsUneTemperatureSuperieureA(double temperature) {
        for (double temp : tableDesTemperatures) {
            if (temp > temperature) {
                return true;
            }
        }
        return false;
    }

    public double temperatureMax() {
        double max = tableDesTemperatures[0];
        for (double temperature : tableDesTemperatures) {
            if (temperature > max) {
                max = temperature;
            }
        }
        return max;
    }

    public int[] joursMax() {
        double maxTemperature = temperatureMax();
        int count = 0;
        for (double temperature : tableDesTemperatures) {
            if (temperature == maxTemperature) {
                count++;
            }
        }
        int[] joursMaxArray = new int[count];
        int index = 0;
        for (int i = 0; i < tableDesTemperatures.length; i++) {
            if (tableDesTemperatures[i] == maxTemperature) {
                joursMaxArray[index] = i;
                index++;
            }
        }
        return joursMaxArray;
    }

    public int[] joursMin() {
        double minTemperature = temperatureMin();
        int count = 0;
        for (double temperature : tableDesTemperatures) {
            if (temperature == minTemperature) {
                count++;
            }
        }
        int[] joursMinArray = new int[count];
        int index = 0;
        for (int i = 0; i < tableDesTemperatures.length; i++) {
            if (tableDesTemperatures[i] == minTemperature) {
                joursMinArray[index] = i;
                index++;
            }
        }
        return joursMinArray;
    }
}
