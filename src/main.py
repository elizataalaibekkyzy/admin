import tkinter as tk;
from tkinter.constants import NW;
from tkinter import Button, Label, Tk, filedialog;
import os;
from img_detection import ImageDetection
from live_detection import LiveDetection;

class App:
    def __init__(self):
        self.window = Tk()
        self.window.geometry('1200x800+150+150')
        self.window.title("Emotion Detection")
        #self.img_label = Label(self.window, background="gray", text = "upload an image", width=100, height=30)
        #self.img_label.place(x=130, y=50)
        self._exit_btn = Button(self.window, text = "exit", width = 20, command = self.window.quit, highlightbackground='lightgray')
        self._select_btn = Button(self.window, text="upload image", command=self._load_image, width=20, highlightbackground='lightgray')
        self._live_btn = Button(self.window, text="live detection", command=self._live_func, width=20, highlightbackground='lightgray')
        self._select_btn.place(x=580, y=600, anchor=tk.N)
        self._live_btn.place(x=580, y=630, anchor=tk.N)
        self._exit_btn.place(x=580,y=660,anchor=tk.N)

        #Graphics window
        imageFrame = tk.Frame(self.window, width=600, height=500)
        imageFrame.grid(row=0, column=0, padx=10, pady=2)

        #Capture video frames
        self.video_frame = tk.Label(imageFrame)
        self.video_frame.grid(row=0, column=0)

        self.window.mainloop()
        pass
    
    def _load_image(self):
        filenames = filedialog.askopenfilenames(
            title="Choose a file",
            filetypes=('image files', ('.png', '.jpg'))
        )

        if len(filenames) != 0:
            ImageDetection.get_img_classified(filenames[0])
        else:
            print("Choose an Image!")
        pass

    def _live_func(self):
        LiveDetection.live_face_expression(self.video_frame)
        pass

if __name__ == '__main__':
    App()