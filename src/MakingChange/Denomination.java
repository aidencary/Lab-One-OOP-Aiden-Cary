package MakingChange;

public record Denomination(String name, double amt, String form, String img) {
// String name is the name of the denomination. Ex. Ten note, Five note, Dime, Nickel, etc...
// double amt is the amount of money the denomination represents
// String from distinguishes if the denomination is a "bill" or a "coin"
// String img is the string containing the image name for an image of the type of money
}