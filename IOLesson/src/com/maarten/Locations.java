package com.maarten;

import java.io.*;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
//        try (BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
//             BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))) {
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                for (String direction : location.getExits().keySet()) {
//                    if(!direction.equalsIgnoreCase("Q")) {
//                        dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
//                    }
//                }
//            }
//        }

        Path locPath = FileSystems.getDefault().getPath("locations.dat");
        try(ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(locPath)))) {
            for(Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }


    }
        static {

        Path locPath = FileSystems.getDefault().getPath("locations.dat");
        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(locPath)))) {
            boolean eof = false;
            while(!eof){
                try {
                    Location location = (Location) locFile.readObject();
                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

//            Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
//            Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");
//
//            try(Scanner scanner = new Scanner(Files.newBufferedReader(locPath))){
//                scanner.useDelimiter(",");
//                while (scanner.hasNext()){
//                    int loc = scanner.nextInt();
//                    scanner.skip(scanner.delimiter());
//                    String description = scanner.nextLine();
//                    System.out.println("Imported loc :" + loc + " : " + description);
//                    locations.put(loc, new Location(loc, description, null));
//                }
//
//            } catch(IOException e) {
//                e.printStackTrace();
//            }
//
//            try(BufferedReader dirFile = Files.newBufferedReader(dirPath)) {
//                String input;
//                while ((input = dirFile.readLine()) !=null ) {
//                    String[] data = input.split(",");
//                    int loc = Integer.parseInt(data[0]);
//                    String direction = data[1];
//                    int destination = Integer.parseInt(data[2]);
//                    Location location = locations.get(loc);
//                    location.addExit(direction, destination);
//                }
//
//            } catch (IOException e ) {
//                e.printStackTrace();
//            }
        }
//
//
//        Map<String, Integer> tempExit = new HashMap<>();
//        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("W", 2);
//        tempExit.put("E", 3);
//        tempExit.put("S", 4);
//        tempExit.put("N", 5);
//        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("N", 5);
//        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("W", 1);
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("N", 1);
//        tempExit.put("W", 2);
//        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("S", 1);
//        tempExit.put("W", 2);
//        locations.put(5, new Location(5, "You are in a forest", tempExit));
//    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
