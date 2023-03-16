package prog2.exercise5.flight.booking.system;
//package exercise3.flight.booking.system;
import java.time.LocalDate;
public class FlightBooking {
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    private String flightCompany = "Flights-of-Fancy";
    private String flightID;
    //private  String[] passengerFullName=new String[3];
    private String[] passengerFullName;
    //private String[] passengerGender=new String[3];
    private String[] passengerGender;
    //private int[] passengerAge=new int[3];
    private int[] passengerAge;
    //private String[] ticketNumber=new String[6];
    private String[] ticketNumber;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private int childPassengers;
    private int adultPassengers;
    private int totalPassengers;
    private double departingTicketPrice;
    private double returnTicketPrice;
    private double totalTicketPrice;
    //private String ticketNumber;
    private TripSource tripSource;
    private BookingClass bookingClass;
    private TripDestination tripDestination;
    private TripType tripType;
    private SourceAirport sourceAirport;
    private DestinationAirport destinationAirport;
    private boolean isUpdate = false;

    enum SourceAirport {
        Nanjing_Lukou_International_Airport, Beijing_Capital_International_Airport,
        Shanghai_Pudong_International_Airport, Oulu_Airport, Helsinki_Airport,
        Paris_Charles_de_Gaulle_Airport
    }

    enum DestinationAirport {
        Nanjing_Lukou_International_Airport, Beijing_Capital_International_Airport,
        Shanghai_Pudong_International_Airport, Oulu_Airport,
        Helsinki_Airport, Paris_Charles_de_Gaulle_Airport
    }

    ;

    enum BookingClass {FIRST, BUSINESS, ECONOMY}

    ;

    enum TripType {ONE_WAY, RETURN}

    ;

    enum TripSource {NANJING, BEIJING, SHANGHAI, OULU, HELSINKI, PARIS}

    ;

    enum TripDestination {NANJING, BEIJING, SHANGHAI, OULU, HELSINKI, PARIS}

    public FlightBooking(String[] passengerFullName, LocalDate departureDate, LocalDate returnDate,
                         int childPassengers, int adultPassengers) {
        this.passengerFullName = passengerFullName;
        this.childPassengers = childPassengers;
        this.adultPassengers = adultPassengers;
        this.totalPassengers = childPassengers + adultPassengers;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
       /* // Generate flight ID and ticket number
        //this.flightID =generate();
        this.flightID = "FOF" + (int) (Math.random() * 10000) + "IN";
        //this.ticketNumber = "TN" + (int) (Math.random() * 10000);
        // Set ticket prices
        this.departingTicketPrice = adultPassengers * 80;
        this.returnTicketPrice = childPassengers * 50;
        this.totalTicketPrice = totalTicketPrice;
        this.bookingClass = bookingClass;
        this.tripType = tripType;
        this.tripSource = tripSource;
        this.tripDestination = tripDestination;*/
    }

    public FlightBooking(int size) {
        this.passengerFullName = new String[size];
        this.passengerGender = new String[size];
        this.passengerAge = new int[size];
        this.ticketNumber = new String[size];
    }

    public double getDepartingTicketPrice() {
        return departingTicketPrice;
    }

    public void setDepartingTicketPrice(int childPassengers, int adultPassengers) {
        this.childPassengers = childPassengers;
        this.adultPassengers = adultPassengers;
    }

    public double getReturnTicketPrice() {
        return returnTicketPrice;
    }

    public void setReturnTicketPrice() {
        this.returnTicketPrice = returnTicketPrice;
    }

    public double getTotalTicketPrice() {
        return totalTicketPrice;
    }

    //public void setTotalTicketPrice()
    public void setTotalTicketPrice() {
        if ((tripSource == TripSource.NANJING && tripDestination == TripDestination.BEIJING) || (tripSource == TripSource.BEIJING && tripDestination == TripDestination.NANJING)) {
            this.totalTicketPrice = (adultPassengers + childPassengers) * (300 + (300 * 0.1) + (300 * 0.05));

        } else if ((tripSource == TripSource.OULU && tripSource == TripSource.HELSINKI) || tripSource == TripSource.HELSINKI && tripSource == TripSource.OULU) {
            this.totalTicketPrice = (adultPassengers + childPassengers) * (300 + (300 * 0.1) + (300 * 0.05));
        } else {
            this.totalTicketPrice = (adultPassengers + childPassengers) * (300 + (300 * 0.15) + (300 * 0.1));
        }
//        if (childPassengers > 0) {
//            double child = 0.0;
//            this.totalTicketPrice = this.totalTicketPrice * childPassengers;
//        }
        switch (bookingClass) {
            case FIRST:
                this.totalTicketPrice = this.totalTicketPrice + (250 *adultPassengers);
                break;
            case BUSINESS:
                this.totalTicketPrice = this.totalTicketPrice + (150 * adultPassengers);
                break;
            case ECONOMY:
                this.totalTicketPrice = this.totalTicketPrice + (50 * adultPassengers);
                break;
        }
        switch (tripType) {
            case ONE_WAY:
                this.totalTicketPrice = this.totalTicketPrice;
                break;
            case RETURN:
                this.totalTicketPrice = this.totalTicketPrice * 2;
        }
    }

    public void setSourceAirport(String tripDestination) {
        if (!tripSource.equals(tripDestination)) {
            switch (tripDestination) {
                case "1":
                    this.sourceAirport = SourceAirport.Nanjing_Lukou_International_Airport;
                    break;
                case "2":
                    this.sourceAirport = SourceAirport.Beijing_Capital_International_Airport;
                    break;
                case "3":
                    this.sourceAirport = SourceAirport.Oulu_Airport;
                    break;
                case "4":
                    this.sourceAirport = SourceAirport.Helsinki_Airport;
                    break;
            }
        }
    }

    public DestinationAirport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String tripSource, String tripDestination) {

        if (!tripSource.equals(tripDestination)) {
            switch (tripDestination) {
                case "1":
                    this.destinationAirport = DestinationAirport.Nanjing_Lukou_International_Airport;
                    break;
                case "2":
                    this.destinationAirport = DestinationAirport.Beijing_Capital_International_Airport;
                    break;
                case "3":
                    this.destinationAirport = DestinationAirport.Oulu_Airport;
                    break;
                case "4":
                    this.destinationAirport = DestinationAirport.Helsinki_Airport;
                    break;
            }
        }
    }

    public TripSource getTripSource() {
        return tripSource;
    }

    public void setTripSource(String tripSource) {
        switch (tripSource) {
            case "1":
                this.tripSource = TripSource.NANJING;
                break;
            case "2":
                this.tripSource = TripSource.BEIJING;
                break;
            case "3":
                this.tripSource = TripSource.OULU;
                break;
            case "4":
                this.tripSource = TripSource.HELSINKI;
        }
    }

    public void setTripDestination(String tripSource, String tripDestination) {
        if (!tripSource.equals(tripDestination)) {
            switch (tripDestination) {
                case "1":
                    this.tripDestination = TripDestination.NANJING;
                    break;
                case "2":
                    this.tripDestination = TripDestination.BEIJING;
                    break;
                case "3":
                    this.tripDestination = TripDestination.OULU;
                    break;
                case "4":
                    this.tripDestination = TripDestination.HELSINKI;
                    break;
            }
        }
    }

    public TripDestination getTripDestination() {
        return tripDestination;
    }

    public void setBookingClass(String bookingClass) {
        switch (bookingClass) {
            case "1":
                this.bookingClass = BookingClass.FIRST;
                break;
            case "2":
                this.bookingClass = BookingClass.BUSINESS;
                break;
            case "3":
                this.bookingClass = BookingClass.ECONOMY;
                break;
        }
    }

    public BookingClass getBookingClass() {
        return bookingClass;
    }

    public void setTripType(String tripType) {
        switch (tripType) {
            case "1":
                this.tripType = TripType.ONE_WAY;
                break;
            case "2":
                this.tripType = TripType.RETURN;
        }
    }

    // Getters , setters
    public TripType getTripType() {
        return tripType;
    }

    public void setTotalPassengers(int childPassengers, int adultPassengers) {
        this.totalPassengers = childPassengers + adultPassengers;
    }

    public int getTotalPassengers() {
        return totalPassengers;
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public void setFlightCompany(String FlightCompany) {
        this.flightCompany = FlightCompany;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getPassengerFullName(int index) {
        return passengerFullName[index];
    }

    public void setPassengerFullName(int index, String passengerFullName) {
        this.passengerFullName[index] = passengerFullName;
    }

    public String getPassengerGender(int index) {
        return passengerGender[index];
    }

    public void setPassengerGender(int index, String passengerGender) {
        this.passengerGender[index] = passengerGender;
    }

    public int getPassengerAge(int index) {
        return passengerAge[index];
    }

    public void setPassengerAge(int index, int passengerAge) {
        this.passengerAge[index] = passengerAge;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        int daysBetween = (int) departureDate.until(returnDate).getDays();
        if (departureDate.equals(returnDate)) {
            isUpdate = true;
            returnDate = departureDate.plusDays(2);
            this.returnDate = returnDate;
        } else if (daysBetween < 2) {
            isUpdate = true;
            returnDate = departureDate.plusDays(2);
            this.returnDate = returnDate;
        } else {
            this.returnDate = returnDate;
        }
    }

    public int getChildPassengers() {
        return childPassengers;
    }

    public void setChildPassengers(int childPassengers) {
        this.childPassengers = childPassengers;
        this.totalPassengers = this.childPassengers + this.adultPassengers;
    }

    public int getAdultPassengers() {
        return adultPassengers;
    }

    public void setAdultPassengers(int adultPassengers) {
        this.adultPassengers = adultPassengers;
        this.totalPassengers = this.childPassengers + this.adultPassengers;
    }

    public void setDepartingTicketPrice(int departingTicketPrice) {
        this.departingTicketPrice = departingTicketPrice;
    }

    public String getTicketNumber(int index) {
        setTicketNumber(index);
        return ticketNumber[index];
    }

    public void setTicketNumber(int index) {

        switch (tripType) {
            case ONE_WAY:
                this.ticketNumber[index] = "11";
                break;
            case RETURN:
                this.ticketNumber[index] = "22";
                break;
        }
        switch (bookingClass) {
            case FIRST:
                this.ticketNumber[index] = this.ticketNumber[index] + "F" + (int) (Math.random() * 10000);
                break;
            case BUSINESS:
                this.ticketNumber[index] = this.ticketNumber[index] + "B" + (int) (Math.random() * 10000);
                break;
            case ECONOMY:
                this.ticketNumber[index] = this.ticketNumber[index] + "E" + (int) (Math.random() * 10000);
                break;
        }
        if ((tripSource == TripSource.NANJING && tripDestination == TripDestination.BEIJING) || (tripSource == TripSource.BEIJING && tripDestination == TripDestination.NANJING)) {
            this.ticketNumber[index] = this.ticketNumber[index] + "DOM.";
        } else if ((tripSource == TripSource.OULU && tripDestination == TripDestination.HELSINKI) || (tripSource == TripSource.HELSINKI && tripDestination == TripDestination.OULU)) {
            this.ticketNumber[index] = this.ticketNumber[index] + "DOM.";
        } else {
            this.ticketNumber[index] = this.ticketNumber[index] + "INT.";
        }
    }

    public void reserveTickets(int size, String tripSource, String tripDestination, String tripType, String bookingClass) {
        String[] fullName = new String[size];
        String[] gender = new String[size];
        int[] age = new int[size];

        for (int i = 0; i < size; i++) {
            setPassengerFullName(i, fullName[i]);
            setPassengerGender(i, gender[i]);
            setPassengerAge(i, age[i]);
        }
        setTripSource(tripSource);
        setSourceAirport(tripDestination);
        setTripDestination(tripSource, tripDestination);
        setDestinationAirport(tripSource, tripDestination);
        setTripType(tripType);
        setBookingClass(bookingClass);
        setDepartureDate(departureDate);
        setReturnDate(returnDate);
        setDepartingTicketPrice(childPassengers, adultPassengers);
        setReturnTicketPrice();
        setTotalTicketPrice();
        for (int j = 0; j < size; ++j) {
            setTicketNumber(j);
        }
    }
    public String displayTripDetails() {
        int daysBetween = (int) departureDate.until(returnDate).getDays();
        String dis1 = String.format("Thank you for booking your flights with %s\n.", this.flightCompany) +
                String.format(" You reserved a total of %s tickets\n", ticketNumber.length);
        String dis2 = null;
        if (isUpdate == true && departureDate.equals(returnDate)) {
            for (int i = 0; i < ticketNumber.length; i++) {
                dis2 = String.format("Here are the trip details for Passenger No.%s\n", (i + 1)) +
                        String.format("Passenger's Ticket Number:%s\n ", this.ticketNumber[i]) +
                        String.format("Passenger's Full Name:%s\n", this.passengerFullName[i]) +
                        String.format("Passenger's Age: %d\n", this.passengerAge[i]) +
                        String.format("Passenger's Gender:%s\n", this.passengerGender[i]) +
                        String.format("From: %s (%s)\n", this.tripSource, this.sourceAirport) +
                        String.format("To: %s (%s)\n", this.tripDestination, this.destinationAirport) +
                        String.format("The flight departs on: %tF\n", this.departureDate) +
                        String.format("And the return flight is on%tF:  (Changed from old  %tF to new\n" +
                                "%tF)\n", this.returnDate, this.departureDate, this.returnDate);

            }
        } else if (isUpdate == true && daysBetween < 2) {
            for (int i = 0; i < ticketNumber.length; i++) {
                dis2 = String.format("Here are the trip details for Passenger No.%s\n", (i + 1)) +
                        String.format("Passenger's Ticket Number:%s\n ", this.ticketNumber[i]) +
                        String.format("Passenger's Full Name:%s\n", this.passengerFullName[i]) +
                        String.format("Passenger's Age: %d\n", this.passengerAge[i]) +
                        String.format("Passenger's Gender:%s\n", this.passengerGender[i]) +
                        String.format("From: %s (%s)\n", this.tripSource, this.sourceAirport) +
                        String.format("To: %s (%s)\n", this.tripDestination, this.destinationAirport) +
                        String.format("The flight departs on: %tF\n", this.departureDate) +
                        String.format("And the return flight is on %tF:  (Changed from old  %tF to new\n" +
                                "%tF)\n", this.returnDate, departureDate.plusDays(1), this.returnDate);

            }

        } else {
            for (int i = 0; i < ticketNumber.length; i++) {
                dis2 = String.format("Here are the trip details for Passenger No.%s\n", (i + 1)) +
                        String.format("Passenger's Ticket Number:%s\n ", this.ticketNumber[i]) +
                        String.format("Passenger's Full Name:%s\n", this.passengerFullName[i]) +
                        String.format("Passenger's Age: %d\n", this.passengerAge[i]) +
                        String.format("Passenger's Gender:%s\n", this.passengerGender[i]) +
                        String.format("From: %s (%s)\n", this.tripSource, this.sourceAirport) +
                        String.format("To: %s (%s)\n", this.tripDestination, this.destinationAirport) +
                        String.format("The flight departs on: %tF\n", this.departureDate) +
                        String.format("And the return flight is on:%tF", this.returnDate);
            }
        }
        String dis3 = String.format("The total ticket price is: %d", this.totalTicketPrice);
        String dis4 = "IMPORTANT NOTICE: As per our policy, the return date was changed because it was less \n" +
                "than two days apart from your departure date.";
        if (isUpdate == true && departureDate.equals(returnDate)) {

            return dis1+dis2+dis3+dis4;
        } else if (isUpdate == true && daysBetween < 2) {
            return dis1 + dis2 + dis3 + dis4;
        } else {
            return dis1 + dis2 + dis3;
        }
    }


    @Override
    public String toString() {
        int daysBetween = (int) departureDate.until(returnDate).getDays();
        String str = "1. First\n" + "2. Business\n" + "3. Economy" +
                "1. One way\n" + "2. Return\n" + "sources and destinations\n" +
                "1. Nanjing\n" + "2. Beijing\n" + "3. Oulu" + "4. Helsinki" +
                String.format("Dear %s. Thank you for booking your flight with %s.\n",
                        this.passengerFullName, this.flightCompany) +
                "Following are the details of your booking and the trip:\n" +
                "Ticket Number: " + this.ticketNumber + "\n" +
                String.format("From %s to %s\n", this.tripSource, this.tripDestination) +
                String.format("Date of departure: %tF\n", this.departureDate) +
                String.format("Date of return: %tF\n", this.returnDate) +
                String.format("Total passengers: %s\n", this.totalPassengers) +
                "Total ticket price in Euros:" + this.totalTicketPrice;
        if (isUpdate == true && departureDate.equals(returnDate)) {
            str = "1. First\n" + "2. Business\n" + "3. Economy" +
                    "1. One way\n" + "2. Return\n" + "sources and destinations\n" +
                    "1. Nanjing\n" + "2. Beijing\n" + "3. Oulu" + "4. Helsinki" +
                    String.format("Dear %s. Thank you for booking your flight with %s.\n",
                            this.passengerFullName, this.flightCompany) +
                    "Following are the details of your booking and the trip:\n" +
                    "Ticket Number: " + this.ticketNumber + "\n" +
                    String.format("From %s to %s\n", this.tripSource, this.tripDestination) +
                    String.format("Date of departure: %tF\n", this.departureDate) +
                    String.format("Date of return: %tF\n", this.returnDate) +
                    String.format("Changed from old  %tF to new %tF", this.departureDate, this.returnDate) +
                    String.format("Total passengers: %s\n", this.totalPassengers) +
                    "Total ticket price in Euros:" + this.totalTicketPrice +
                    "IMPORTANT NOTICE: As per our policy, the return date was changed because it was less than two days apart from your departure date.";
        } else if (isUpdate == true && daysBetween < 2) {
            str = "1. First\n" + "2. Business\n" + "3. Economy" +
                    "1. One way\n" + "2. Return\n" + "sources and destinations\n" +
                    "1. Nanjing\n" + "2. Beijing\n" + "3. Oulu" + "4. Helsinki" +
                    String.format("Dear %s. Thank you for booking your flight with %s.\n",
                            this.passengerFullName, this.flightCompany) +
                    "Following are the details of your booking and the trip:\n" +
                    "Ticket Number: " + this.ticketNumber + "\n" +
                    String.format("From %s to %s\n", this.tripSource, this.tripDestination) +
                    String.format("Date of departure: %tF\n", this.departureDate) +
                    String.format("Date of return: %tF\n", this.returnDate) +
                    String.format("Changed from old  %tF to new %tF", departureDate.plusDays(1), this.returnDate) +
                    String.format("Total passengers: %s\n", this.totalPassengers) +
                    "Total ticket price in Euros:" + this.totalTicketPrice +
                    "IMPORTANT NOTICE: As per our policy, the return date was changed because it was less than two days apart from your departure date.";
        } else {
            str = str;
        }
        return str;
    }
}
