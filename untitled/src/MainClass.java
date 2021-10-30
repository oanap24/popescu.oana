public class MainClass {

    public static void main(String[] args) {
        String space = "15TB";
        Double minPermittedSpace = 10d;
        Double extractedSpace = Double.valueOf(space.replaceAll("[^0-9]", ""));
        String measure = space.replaceAll("[0-9]", "");
        extractedSpace = convertSpacetoDefaultMeasure(extractedSpace, measure);
        String defaultMeasure = "GB";

        System.out.println(extractedSpace + " " + defaultMeasure);

    }

    public static Double convertSpacetoDefaultMeasure(Double space, String measure) {
        System.out.println(space + " " + measure);
        switch (measure){
            case "TB" :
                space = space * 1024;
                break;
            case "MB" :
                space = space /1024;
                break;

        }
        return space;
    }

}
