package lambdas;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WeatherStream {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static DateFormat toYear = new SimpleDateFormat("yyyy");

    public static void main(String[] args) {


        BufferedReader br = null;
        FileWriter fw = null;
        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("rdu-weather-history.csv")));

            fw = new FileWriter("output.csv");
            fw.append("date;temperatureavg\n");

            List<DateTemperature> temps = br.lines().skip(1).map(WeatherStream::parseDT).filter(Objects::nonNull).collect(Collectors.toList());

            fw.append(IntStream
                    .range(2010, 2018)
                    .boxed()
                    .map(i ->
                          new DateTemperature(WeatherStream.getDate(i + "-01-01"),
                           temps.stream()
                           .filter(w -> getYear(w.getDate()) == i)
                           .mapToDouble(w -> w.getTemperature())
                           .average()
                           .getAsDouble())
                          )
                    .map(w -> w.toString())
                    .collect(Collectors.joining("\n")));
            br.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static Date getDate(String s){
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DateTemperature parseDT(String s) {
        try {
            String[] tokens = s.split(";");
            if(tokens[0].isEmpty() || tokens[2].isEmpty())
                return null;
            return new DateTemperature(dateFormat.parse(tokens[0]), Double.parseDouble(tokens[2]));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getYear(Date d){
        return Integer.parseInt(toYear.format(d));
    }



}
