package me.gus.gui_captcha.gui_captcha.menu;

import me.gus.gui_captcha.gui_captcha.util.util;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Random;

public class menu {
    public static final menu instance = new menu();

    private Random numberGenerator = new Random();

    // your existing variables
    private int firstNumber;
    private int secondNumber;
    private int numbersSum;
    private int botAnswer;
    private int botAnswer2;
    private int setRandomSlot;
    private int setRandomSlotDva;
    private int setRandomSlotThree;

// your existing inventory


    // constructor to set inventory items with initial random numbers
    private menu() {
// call the random number generator method
        generateRandomNumbers();
    }

    // new random number generator method
    public void generateRandomNumbers() {
// generate first and second numbers
        this.firstNumber = numberGenerator.nextInt(4) + 1;
        this.secondNumber = numberGenerator.nextInt(4) + 1;

// change second number if equal to first number
        while (this.firstNumber == this.secondNumber) {
            this.secondNumber = numberGenerator.nextInt(4) + 1;
        }

// calculate sum of numbers
        this.numbersSum = firstNumber + secondNumber;

// generate bot answers
        this.botAnswer = numberGenerator.nextInt(15) + 6;
        this.botAnswer2 = numberGenerator.nextInt(11) + 2;

// set random inventory slots
        this.setRandomSlot = (int) ((Math.random() * (52 - 1)) + 1);
        this.setRandomSlotDva = (int) ((Math.random() * (51 - 1)) + 1);
        this.setRandomSlotThree = (int) ((Math.random() * (49 - 1)) + 1);
    }

    public void openInventory(Player player) {
        generateRandomNumbers();
        final Inventory inventory = Bukkit.createInventory(null, 54, "Вычисли: " + firstNumber + " + " + secondNumber + " = ???");
        inventory.setItem(setRandomSlot, util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(numbersSum)));
        inventory.setItem(setRandomSlot + 2, util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(botAnswer)));
        inventory.setItem(setRandomSlotDva + 3, util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(botAnswer2)));
        player.openInventory(inventory);
    }
    public Inventory getInventory(Player player) {
        generateRandomNumbers();
        final Inventory inventory = Bukkit.createInventory(null, 54, "Вычисли: " + firstNumber + " + " + secondNumber + " = ???");
        inventory.setItem(setRandomSlot, util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(numbersSum)));
        inventory.setItem(setRandomSlot + 2, util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(botAnswer)));
        inventory.setItem(setRandomSlotDva + 3, util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(botAnswer2)));
        player.openInventory(inventory);
        return inventory;
    }

    public int getRandomSlot() {
        return this.setRandomSlot;
    }
    public int getSetRandomSlotDva() {
        return this.setRandomSlotDva;
    }
    public int getSetRandomSlotThree() {
        return this.setRandomSlotThree;
    }
    public int getNumbersSum() {
        return this.numbersSum;
    }
    public int firstNumber() {
        return this.firstNumber;
    }
    public int secondNumber() {
        return this.secondNumber;
    }

    public void openInventoryPlus(Player player) {
        generateRandomNumbers();
        final Inventory inventory = Bukkit.createInventory(null, 54, "Вычислите: " + firstNumber + " + " + secondNumber + " = ???");
        inventory.setItem(setRandomSlot, util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(numbersSum)));
        inventory.setItem(setRandomSlot + 2, util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(botAnswer)));
        inventory.setItem(setRandomSlotDva + 3, util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(botAnswer2)));
        player.openInventory(inventory);
    }
    public Inventory getInventoryPlus(Player player) {
        generateRandomNumbers();
        final Inventory inventory = Bukkit.createInventory(null, 54, "Вычислите: " + firstNumber + " + " + secondNumber + " = ???");
        inventory.setItem(setRandomSlot, util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(numbersSum)));
        inventory.setItem(setRandomSlot + 2, util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(botAnswer)));
        inventory.setItem(setRandomSlotDva + 3, util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(botAnswer2)));
        player.openInventory(inventory);
        return inventory;
    }
    public int getRandomSlotPlus() {
        return this.setRandomSlot;
    }
    public int getSetRandomSlotDvaPlus() {
        return this.setRandomSlotDva;
    }
    public int getSetRandomSlotThreePlus() {
        return this.setRandomSlotThree;
    }
    public int getNumbersSumPlus() {
        return this.numbersSum;
    }
    public int firstNumberPlus() {
        return this.firstNumber;
    }
    public int secondNumberPlus() {
        return this.secondNumber;
    }
}