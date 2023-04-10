import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents complete survey Work on Water (WoW) company
 */
public class Survey {

    private String date;
    private Employee employee;
    private List<Parameter> parameters;
    private QualityBadge qualityBadge;

    /**
     * Default constructor
     */
    public Survey() {
        this.date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        this.parameters = new ArrayList<>();
    }

    /**
     * Parameterized constructor
     *
     * @param employee Employee object
     */
    public Survey(Employee employee) {
        //set current date  as a string 'YYYY-MM-DD'
        this.date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        this.employee = employee;
        this.parameters = new ArrayList<>();

    }

    //getters and setters
    public String getDate() {
        return date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public QualityBadge getQualityBadge() {
        return qualityBadge;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public void setQualityBadge(QualityBadge qualityBadge) {
        this.qualityBadge = qualityBadge;
    }


    private void addParameter(Parameter parameter) {
        this.parameters.add(parameter);
    }

    /**
     * Reads data from text file and store it in List<Parameter> parameters
     *
     * @param fileName file name
     * @return true if success otherwise return false
     * @throws FileNotFoundException if file not found
     */
    public boolean readFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("File does not exist");
        }
        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter("\n");
            Parameter parameter;
            while (scanner.hasNextLine()) {
                String lineValues = scanner.nextLine();
                parameter = createParameterFromStringLine(lineValues);
                if (parameter != null) {
                    addParameter(parameter);
                }
            }
            return true;
        } catch (Exception e) {
            System.err.println("Can not read data from file: " + fileName);


        }

        return false;
    }

    /**
     * Converts the text representation of the parameter to a Parameter object
     *
     * @param line text representation of the Parameter object
     * @return Parameter object
     */
    private Parameter createParameterFromStringLine(String line) {
        final String delimeter = ",";
        String[] arr = line.split(delimeter);
        if (arr.length == 4) {
            return new Parameter(
                    arr[0],
                    Double.parseDouble(arr[1]),
                    Double.parseDouble(arr[2]),
                    Double.parseDouble(arr[3]));
        }

        return null;

    }


    /**
     * Calculates the number of parameters out of range
     *
     * @param parameters Parameter list
     * @return number of parameters out of range
     */
    public int rateMySample(List<Parameter> parameters) {
        int rate = 0;
        for (Parameter parameter : parameters) {
            if (parameter.getValue() < parameter.getMinRange() || parameter.getValue() > parameter.getMaxRange()) {
                rate++;
            }

        }
        return rate;
    }

    /**
     * Sets the quality badge depending on the number of parameters out of range
     *
     * @param rate number of parameters out of range
     */
    public void badgeAssignment(int rate) {

        switch (rate) {
            case 0:
                setQualityBadge(QualityBadge.SUBLIME);
                break;
            case 1:
                setQualityBadge(QualityBadge.GOOD);
                break;
            case 2:
                setQualityBadge(QualityBadge.NEUTRAL);
                break;
            case 3:
                setQualityBadge(QualityBadge.BAD);
                break;
            case 4:
                setQualityBadge(QualityBadge.TERRIBLE);
                break;
            default:
                setQualityBadge(QualityBadge.DISASTER);
        }
    }

    /**
     * String representation of the Survey class
     *
     * @return String representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("===========================Survey=============================\n")
                .append(employee.toString())
                .append("Parameters:\n")
                .append(String.format("%-23s %12s %12s %12s\n", "Name", "Value", "Min Range", "Max Range"))
                .append("--------------------------------------------------------------\n");
        for (Parameter parameter : parameters) {
            sb.append(parameter);
        }
        sb.append("--------------------------------------------------------------\n");
        sb.append("Quality badge: ").append(qualityBadge);
        return sb.toString();

    }


}
