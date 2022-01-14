from tensorflow.keras.layers import Activation, Conv2D, BatchNormalization, Dense, Dropout, Flatten, MaxPooling2D
from tensorflow.keras.optimizers import Adam
from tensorflow.keras.models import Sequential

class Model():

    def create_model():
        model = Sequential()
        X_shape = (48, 48, 1)

        model.add(Conv2D(64, (3, 3), input_shape=X_shape))
        model.add(Activation('relu'))
        model.add(MaxPooling2D(pool_size=(2, 2)))
        model.add(Dropout(0.25))

        model.add(Conv2D(128, (5, 5)))
        model.add(Activation('relu'))
        model.add(MaxPooling2D(pool_size=(2, 2)))
        model.add(Dropout(0.25))

        model.add(Flatten())

        model.add(Dense(256))
        model.add(BatchNormalization())
        model.add(Activation('relu'))
        model.add(Dropout(0.25))

        model.add(Dense(512))
        model.add(BatchNormalization())
        model.add(Activation('relu'))
        model.add(Dropout(0.25))

        number_possible_outputs = 7
        model.add(Dense(number_possible_outputs))

        model.add(Activation('softmax'))

        opt = Adam(learning_rate=0.00005)
        model.compile(optimizer=opt, loss='categorical_crossentropy',
                    metrics=['accuracy'])
        model.summary()

        return model