package ITITWE23014_LTDANH_LAB3.Problem_II;
import java.util.Stack;

class SpecialArray {
    private int[] array = new int[20];
    private Stack<int[]> undoStack = new Stack<>();
    private Stack<int[]> redoStack = new Stack<>();

    public SpecialArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
    }

    public void updateValue(int index, int newValue) {
        undoStack.push(array.clone());
        array[index] = newValue;
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(array.clone());
            array = undoStack.pop();
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(array.clone());
            array = redoStack.pop();
        }
    }

    public void displayArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SpecialArray specialArray = new SpecialArray();
        specialArray.displayArray();
        specialArray.updateValue(5, 42);
        specialArray.displayArray();
        specialArray.undo();
        specialArray.displayArray();
        specialArray.redo();
        specialArray.displayArray();
    }
}