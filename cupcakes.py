# returns the min 5 inputted flavours by the baker in the form of a list
def get_new_flavours():
    while True:
        new_flavours = []
        print("Input your new flavours, each seperated by a comma (leave blank if you would like to get to the changing settings):\n")
        string_new_flavours = input()
        if string_new_flavours == "":
            return
        new_flavours = string_new_flavours.split(",")
        if len(new_flavours) < 5:
            print("Add at least 5 new flavours")
        else:
            break
    return new_flavours

# edits the cupcakes file and has the option to ovewrite the file (used in the change_or_remove_flavour function)
def write_flavours(flavours, overwrite=False):
    if flavours == None:
        return
    if not overwrite:
        with open("cupcakes.txt", 'a') as file:
            for flavour in flavours:
                file.write(f"{flavour}\n")
    else:
        with open("cupcakes.txt", 'w') as file:
            for flavour in flavours:
                file.write(f"{flavour}\n")

# returns all the flavours in the cupcakes text file in the form of a list
def read_flavours():
    with open("cupcakes.txt", 'r') as file:
        raw_flavours = file.readlines()
        flavours = []
        for flavour in raw_flavours:
            flavour = flavour.strip("\n")
            flavours.append(flavour)
    return flavours

# changes a flavour in the cupcakes text file
def change_or_remove_flavour(unwanted_flavour, replacement_flavour=""):
    flavours_list = read_flavours()
    new_flavours_list = []
    for flavour in flavours_list:
        if flavour != unwanted_flavour:
            new_flavours_list.append(flavour)
        else:
            if replacement_flavour != "":
                new_flavours_list.append(replacement_flavour)
            else:
                continue
    write_flavours(new_flavours_list, True)

#returns the menu as an f string
def create_menu():
    flavours = read_flavours()
    menu = "Fantastic Flavours Of The Day:\n"
    for flavour in flavours:
        if flavour[0] == " ":  # so output is the same wether spaces were between the inputted flavours or not
            menu = f"{menu} -{flavour}\n"
        else:
            menu = f"{menu} - {flavour}\n"
    return menu

# prints the main menu
def create_main_menu():
    print("""What would you like to do?
    -Add Flavours = ADD
    -Replace Flavours = RPLC
    -Remove flavours = RMV
    -Output new Menu = MN
    -Exit = EXT""")

    


# the executed function
def main():
    while True:
        create_main_menu()
        answer = input().upper()

        if answer == 'ADD':
            write_flavours(get_new_flavours())
        elif answer == 'RPLC':
            print("Type the flavour you wish to replace, followed by a comma, followed by the flavour you wish to replace it with")
            answer2 = input().split(",")
            change_or_remove_flavour(answer2[0], answer2[1])
        elif answer == 'RMV':
            print("Which flavour would you like to remove?")
            change_or_remove_flavour(input())
        elif answer == 'MN':
            print(create_menu())
        elif answer == 'EXT':
            break
        else:
            print("Please enter a valid answer")
