package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DivisibleChallengeTest {
    @Test
    void itShouldReturnMessageTill1() {
        String expectValueFor1 = "1";

        assertThat(DivisibleChallenge.customMessageForDivisibleNumber(1, 1)).isEqualTo(expectValueFor1);
    }

    @Test
    void itShouldReturnEmptyMessage() {
        String emptyMessage = "";
        assertThat(DivisibleChallenge.customMessageForDivisibleNumber(1, 0)).isEqualTo(emptyMessage);
    }

    @Test
    void itShouldReturnMessageTill30() {
        String expectValueFor30 = "1\n2\nVisual\n4\nNuts\nVisual\n7\n8\nVisual\nNuts\n11\nVisual\n13\n14\n" +
                "Visual Nuts\n16\n17\nVisual\n19\nNuts\nVisual\n22\n23\nVisual\nNuts\n26\nVisual\n28\n29\n" +
                "Visual Nuts";
        assertThat(DivisibleChallenge.customMessageForDivisibleNumber(1, 30)).isEqualTo(expectValueFor30);
    }

    @Test
    void itShouldReturnMessageTill100() {
        String expectValueFor100 = "1\n2\nVisual\n4\nNuts\nVisual\n7\n8\nVisual\nNuts\n11\nVisual\n13\n14\n" +
                "Visual Nuts\n16\n17\nVisual\n19\nNuts\nVisual\n22\n23\nVisual\nNuts\n26\nVisual\n28\n29\n" +
                "Visual Nuts\n31\n32\nVisual\n34\nNuts\nVisual\n37\n38\nVisual\nNuts\n41\nVisual\n43\n44\n" +
                "Visual Nuts\n46\n47\nVisual\n49\nNuts\nVisual\n52\n53\nVisual\nNuts\n56\nVisual\n58\n59\n" +
                "Visual Nuts\n61\n62\nVisual\n64\nNuts\nVisual\n67\n68\nVisual\nNuts\n71\nVisual\n73\n74\n" +
                "Visual Nuts\n76\n77\nVisual\n79\nNuts\nVisual\n82\n83\nVisual\nNuts\n86\nVisual\n88\n89\n" +
                "Visual Nuts\n91\n92\nVisual\n94\nNuts\nVisual\n97\n98\nVisual\nNuts";

        assertThat(DivisibleChallenge.customMessageForDivisibleNumber(1, 100)).isEqualTo(expectValueFor100);
    }

    @Test
    void itShouldReturnMessage13Till27() {
        String expectValueFor13To27 = "13\n14\nVisual Nuts\n16\n17\nVisual\n19\nNuts\nVisual\n22\n23" +
                "\nVisual\nNuts\n26\nVisual";
        assertThat(DivisibleChallenge.customMessageForDivisibleNumber(13, 27)).isEqualTo(expectValueFor13To27);
    }

    @Test
    void itShouldReturnMessageMinus27Till1() {
        String expectValueForMinus27Till1 = "Visual\n-26\nNuts\nVisual\n-23\n-22\nVisual\nNuts\n-19\nVisual\n" +
                "-17\n-16\nVisual Nuts\n-14\n-13\nVisual\n-11\nNuts\nVisual\n-8\n-7\nVisual\nNuts\n-4\nVisual\n" +
                "-2\n-1\nVisual Nuts\n1";
        assertThat(DivisibleChallenge.customMessageForDivisibleNumber(-27, 1)).isEqualTo(expectValueForMinus27Till1);
    }

}
