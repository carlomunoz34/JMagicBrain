package org.jmagicbrain.functions;

import org.jmagicbrain.NeuralNetwork;

public class BPErrorFunction extends ErrorFunction {
    /**
     * Inicia la instancia de ErrorFunction
     *
     * @param neuralNetwork Neural network to evaluate
     */
    public BPErrorFunction(NeuralNetwork neuralNetwork) {
        super(neuralNetwork);
    }

    @Override
    public double getError(double[][] trainingSet, double[][] objective) {
        neuralNetwork.setInputLayer(trainingSet[0]);
        neuralNetwork.think();
        double[] outputVector = neuralNetwork.getOutputLayer();
        double error = 0;
        for(int i = 0; i < outputVector.length; i++){
            error += Math.pow(objective[0][i] - outputVector[i], 2);
        }
        return  error * 0.5;

    }
}
