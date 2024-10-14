package Problem_6;

import java.util.*;

class Flight {
    String flightId;
    String time;
    int priority;

    public Flight(String flightId, String time, int priority) {
        this.flightId = flightId;
        this.time = time;
        this.priority = priority;
    }

    public int getTimeInMinutes() {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    @Override
    public String toString() {
        return "(" + flightId + ", " + time + ", Priority: " + priority + ")";
    }
}

public class FlightScheduler {

    public static void mergeSort(List<Flight> flights, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(flights, left, mid);
            mergeSort(flights, mid + 1, right);
            merge(flights, left, mid, right);
        }
    }

    public static void merge(List<Flight> flights, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        List<Flight> leftTemp = new ArrayList<>(n1);
        List<Flight> rightTemp = new ArrayList<>(n2);

        for (int i = 0; i < n1; i++) {
            leftTemp.add(flights.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightTemp.add(flights.get(mid + 1 + j));
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            Flight leftFlight = leftTemp.get(i);
            Flight rightFlight = rightTemp.get(j);

            if (leftFlight.priority > rightFlight.priority ||
                    (leftFlight.priority == rightFlight.priority && leftFlight.getTimeInMinutes() < rightFlight.getTimeInMinutes())) {
                flights.set(k, leftFlight);
                i++;
            } else {
                flights.set(k, rightFlight);
                j++;
            }
            k++;
        }

        while (i < n1) {
            flights.set(k, leftTemp.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            flights.set(k, rightTemp.get(j));
            j++;
            k++;
        }
    }// di ngu

    public static List<String> scheduleFlights(List<Flight> flights, int R) {

        mergeSort(flights, 0, flights.size() - 1);

        List<List<Flight>> runways = new ArrayList<>(R);
        for (int i = 0; i < R; i++) {
            runways.add(new ArrayList<>());
        }

        List<Flight> unscheduledFlights = new ArrayList<>();
        for (Flight flight : flights) {
            boolean assigned = false;
            for (int i = 0; i < R; i++) {
                List<Flight> runwayFlights = runways.get(i);

                if (runwayFlights.isEmpty() || runwayFlights.get(runwayFlights.size() - 1).getTimeInMinutes() <= flight.getTimeInMinutes()) {
                    runwayFlights.add(flight);
                    assigned = true;
                    break;
                }
            }
            if (!assigned) {
                unscheduledFlights.add(flight);
            }
        }

        List<String> output = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            List<Flight> runwayFlights = runways.get(i);
            StringBuilder sb = new StringBuilder("Runway " + (i + 1) + ": ");
            if (!runwayFlights.isEmpty()) {
                for (Flight f : runwayFlights) {
                    sb.append(f.flightId).append(" (").append(f.time).append("), ");
                }
                sb.setLength(sb.length() - 2);
            } else {
                sb.append("No flights scheduled.");
            }
            output.add(sb.toString());
        }

        if (!unscheduledFlights.isEmpty()) {
            StringBuilder unscheduled = new StringBuilder("Unscheduled Flights: ");
            for (Flight f : unscheduledFlights) {
                unscheduled.append(f.flightId).append(" (").append(f.time).append("), ");
            }
            unscheduled.setLength(unscheduled.length() - 2);
            output.add(unscheduled.toString());
        }

        return output;
    }

    public static void main(String[] args) {
        List<Flight> flights = Arrays.asList(
                new Flight("F1", "10:00", 2),
                new Flight("F2", "09:30", 1),
                new Flight("F3", "09:30", 2),
                new Flight("F4", "11:00", 1)
        );

        int runways = 2;

        List<String> scheduledFlights = scheduleFlights(flights, runways);

        scheduledFlights.forEach(System.out::println);
    }
}