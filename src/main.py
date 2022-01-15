import tkinter as tk;
from tkinter import Button, Tk, filedialog
from classification_emotions import Classifictions;
import cv2
from model import Model;
from PIL import Image, ImageTk

model = Model.create_model()
model.load_weights('./src/model_2022-01-08.h5')

width, height = 800, 600
cap = cv2.VideoCapture(0)
cap.set(cv2.CAP_PROP_FRAME_WIDTH, width)
cap.set(cv2.CAP_PROP_FRAME_HEIGHT, height)


class App:
    def __init__(self):
        self.window = Tk()
        self.window.geometry('1200x850+150+150')
        self.window.title("Emotion Detection")
        self._exit_btn = Button(
            self.window,
            text = "exit",
            width = 20,
            command = self.window.quit,
            highlightbackground='lightgray'
        )
        self._select_btn = Button(
            self.window,
            text="upload image",
            command=self._load_image,
            width=20,
            highlightbackground='lightgray'
        )
        self._live_btn = Button(
            self.window,
            text="live detection",
            command=self._live_func,
            width=20,
            highlightbackground='lightgray'
        )

        # Positioning BUttons
        self._select_btn.place(x=580, y=700, anchor=tk.N)
        self._live_btn.place(x=580, y=730, anchor=tk.N)
        self._exit_btn.place(x=580,y=760,anchor=tk.N)

        #Capture video frames
        self.video_frame = tk.Label(self.window)
        self.video_frame.grid(row=0, column=0)

        self.window.mainloop()
        pass

    def live_face_expression(self):
        _, img = cap.read()
        img = cv2.flip(img, 1)
        
        Classifictions.get_expression_classified(img, model)

        cv2image = cv2.cvtColor(img, cv2.COLOR_BGR2RGBA)
        img = Image.fromarray(cv2image)
        imgtk = ImageTk.PhotoImage(image=img)
        self.video_frame.imgtk = imgtk
        self.video_frame.configure(image=imgtk)
        self.video_frame.after(10, self.live_face_expression)
    
    def _load_image(self):
        filenames = filedialog.askopenfilenames(
            title="Choose a file",
            filetypes=('image files', ('.png', '.jpg'))
        )

        if len(filenames) != 0:
            filename = filenames[0]
            if filename is not  '':
                img = cv2.imread(filename)
                
                width = int(img.shape[1])
                height = int(img.shape[0])
                scale = 100
                while scale*width/100 >= 600 or scale*height/100 >= 800:
                    scale=scale-1
                width = int(img.shape[1] * scale / 100)
                height = int(img.shape[0] * scale / 100)

                # resize image
                dim = (width, height)
                img = cv2.resize(img, dim, interpolation = cv2.INTER_AREA)
                
                Classifictions.get_expression_classified(img, model)
                cv2image = cv2.cvtColor(img, cv2.COLOR_BGR2RGBA)
                img = Image.fromarray(cv2image)
                imgtk = ImageTk.PhotoImage(image=img)
                self.video_frame.imgtk = imgtk
                self.video_frame.configure(image=imgtk)
            else: print("No image selected!")
        else:
            print("Choose an Image!")
        pass

    def _live_func(self):
        self.live_face_expression()
        pass

if __name__ == '__main__':
    App()

