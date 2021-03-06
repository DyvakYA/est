package com.dyvak.est.utils.IOForSellers;

import com.dyvak.est.estate.Seller;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dyvak on 03.08.2016.
 */

public class SellersIOUtils {



    public static final String CSV_DELIMITER = ";";

    private SellersIOUtils() {}

    // Input from Text File

    public static List<Seller> readSellersFromFile(String fileName) throws IOException {
        // try-with-resources (Java 7)
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {
            return readSellers(reader);
        }
    }

    private static List<Seller> readSellers(BufferedReader reader) throws IOException {
        List<Seller> sellers = new LinkedList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            Seller realty = parseSellers(line);
            sellers.add(realty);
        }

        return sellers;
    }

    public static Seller parseSellers(String s) {
        String[] tokens = s.split(CSV_DELIMITER);

        String name = tokens[0];
        String surname = tokens[1];
        String phoneNumber = tokens[2];

        return new Seller(name, surname, phoneNumber) {

          };
        };
}
