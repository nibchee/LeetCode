class Solution {
public:
    bool isLongPressedName(string name, string typed) {

    int i = 0; 
    int j = 0; 

    // Traverse the typed string
    while (j < typed.size()) {

        // CASE 1: Characters match -> move both pointers
        if (i < name.size() && name[i] == typed[j]) {
            i++;
            j++;
        }

        // CASE 2: Characters don't match,
        // but typed[j] is same as its previous char -> long press happened
        else if (j > 0 && typed[j] == typed[j - 1]) {
            j++;  // valid repetition
        }

        // CASE 3: Invalid character (not a match and not a repetition)
        else {
            return false;
        }
    }

    // At the end, all characters of 'name' should be matched
    return i == name.size();
}

};