package com.cinema;

import java.util.ArrayList;


public class Cinema {

    private Seat[][] seats;


    public Cinema(int[] rows) {
        seats = new Seat[rows.length][];
        initSeats(rows);
    }

    private void initSeats(int[] rows) {
        for (int i = 0; i < rows.length; i++) {
            seats[i] = new Seat[rows[i]];
        }
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = new Seat(i, j);
            }
        }
    }

    public int countAvailableSeats() {
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j].isAvailable()) {
                    count +=1;
                }else{
                    count +=0;
                }
            }
        }
        return count;
    }

    public Seat findFirstAvailableSeatInRow(int row) {
        if (seats.length < row ) {
            return null;
        }
        for (int i = 0; i < seats[row].length; i++) {
            if (seats[row][i].isAvailable()) {
                return seats[row][i];
            }
        }
        return null;
    }
    public Seat findFirstAvailableSeat() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j].isAvailable()) {
                    return seats[i][j];
                }
            }
        }return null;
    }
    public Seat getAvailableSeatsInRow(int row, int amount) {
            for (int i = 0; i <= seats[row].length - amount; i++) {
                boolean allAvailable = true;
                for (int j = 0; j < amount; j++) {
                    if (!seats[row][i + j].isAvailable()) {
                        allAvailable = false;
                        break;
                    }
                }
                if (allAvailable) {
                    return seats[row][i];
                }
            }
            return null;
        }
    public Seat getAvailableSeats(int amount) {
        for (int n = 0; n < seats.length; n++) {
        for (int i = 0; i <= seats[n].length - amount; i++) {
            boolean allAvailable = true;
            for (int j = 0; j < amount; j++) {
                if (!seats[n][i + j].isAvailable()) {
                    allAvailable = false;
                    break;
                }
            }
            if (allAvailable) {
                return seats[n][i];
            }
        }
        return null;
    }
        return null;
    }

    /**
     * Marca como ocupadas la cantidad de butacas empezando por la que se le pasa.
     *
     * @param seat   butaca inicial de la serie.
     * @param amount la cantidad de butacas a reservar.
     */
    public void takeSeats(Seat seat, int amount) {
            int fila = seat.getRow();
            int butaca = seat.getSeatNumber();
            if (seat.isAvailable()) {
                for (int i = 0; i < amount; i++) {
                    seats[fila][butaca+i].takeSeat();
                }
            }
        }

        /**
         * Libera la cantidad de butacas consecutivas empezando por la que se le pasa.
         *
         * @param seat   butaca inicial de la serie.
         * @param amount la cantidad de butacas a liberar.
         */
    public void releaseSeats(Seat seat, int amount) {
        int fila = seat.getRow();
        int butaca = seat.getSeatNumber();
        if (!seat.isAvailable()) {
            for (int i = 0; i < amount; i++) {
                seats[fila][butaca+i].releaseSeat();
            }
        }
    }
}