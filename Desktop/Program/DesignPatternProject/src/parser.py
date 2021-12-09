from tkinter import *;
from tkinter import filedialog;


def open_file_dialog():
    
    file_path = filedialog.askopenfilename()
    try:
        file = open(file_path, 'r')
    except:
        text_field.config(text = "File selection failes")
        print("File selection failes")
    
    print(file.read())
    file.close()


window = Tk()
window.geometry('700x400+70+70')
window.title("files parser program")
text_field = Label(window, text = "Select files only txt or xml types").pack(padx=150, pady=20)
select_btn = Button(window, text= 'select file', bg='#000000', width = 20, command= open_file_dialog, highlightbackground='lightgray').pack(padx=150, pady=20)
exit_btn = Button(text = "Exit", width = 20, command = window.destroy, highlightbackground='lightgray').pack()
window.mainloop()