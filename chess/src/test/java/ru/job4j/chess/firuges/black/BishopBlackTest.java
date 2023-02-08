package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    public void testPositionMethod() {
        Figure bishopBlack = new BishopBlack(Cell.F8);
        Cell expected = Cell.F8;
        assertThat(bishopBlack.position()).isEqualTo(expected);
    }

    @Test
    public void testCopyMethod() {
        Figure bishopBlack = new BishopBlack(Cell.F8);
        bishopBlack = bishopBlack.copy(Cell.H6);
        Cell expected = Cell.H6;
        assertThat(bishopBlack.position()).isEqualTo(expected);
    }

    @Test
    public void testDiagonalMethodTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        boolean expected = bishopBlack.isDiagonal(Cell.F8, Cell.H6);
        assertThat(expected).isTrue();
    }

    @Test
    public void testDiagonalMethodTrue2() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B4);
        boolean expected = bishopBlack.isDiagonal(Cell.B4, Cell.D6);
        assertThat(expected).isTrue();
    }

    @Test
    public void testWayC1toG5thenD2E3F4G5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] way = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(way).isEqualTo(expected);
    }

    @Test
    public void testWayA7toG1thenB6C5D4E3F2G1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A7);
        Cell[] way = bishopBlack.way(Cell.G1);
        Cell[] expected = {Cell.B6, Cell.C5, Cell.D4, Cell.E3, Cell.F2, Cell.G1};
        assertThat(way).isEqualTo(expected);
    }

    @Test

    public void testWayIsNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A7);
        ImpossibleMoveException exception = assertThrows(
                    ImpossibleMoveException.class,
                    () -> bishopBlack.way(Cell.G7)
            );
            String expected = String.format(
                    "Could not move by diagonal from %s to %s", Cell.A7, Cell.G7);
            assertThat(exception.getMessage()).isEqualTo(expected);
        }

}