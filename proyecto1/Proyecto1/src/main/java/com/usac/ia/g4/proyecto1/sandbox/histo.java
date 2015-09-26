/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.ia.g4.proyecto1.sandbox;

import org.openimaj.image.FImage;
import org.openimaj.image.MBFImage;
import org.openimaj.image.colour.RGBColour;
import org.openimaj.math.statistics.distribution.Histogram;
import org.openimaj.video.VideoDisplay;
import org.openimaj.video.VideoDisplayListener;
import org.openimaj.video.capture.VideoCapture;

/**
 *
 * @author reimer
 */
public class histo {
//
//    public histo() {
//        try {
////	        XuggleVideo v = new XuggleVideo( new File( "src/test/resources/sailing.mp4") );
//            VideoCapture v = new VideoCapture(320, 240);
//            VideoDisplay<MBFImage> vd = VideoDisplay.createVideoDisplay(v);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Plot a histogram into an image of another image in a given colour.
//     *
//     * @param img The image to plot into
//     * @param img2 The image whose histogram is to be plotted
//     * @param colour The colour in which to plot the histogram.
//     */
//    public void plotHisto(MBFImage img, FImage img2, Float[] colour) {
//        // The number of bins is set to the image width here, but
//        // we could specify a specific amount here.
//        int nBins = img.getWidth();
//
//        // Calculate the histogram
////        Histogram h = HistogramProcessor.getHistogram(img2, nBins);
//
//        // Find the maximum so we can scale the bins
//        double max = h.max();
//
//        // Work out how fat to draw the lines.
//        double lineWidth = img.getWidth() / nBins;
//
//        // Now draw all the bins.
//        int x = 0;
//        for (double d : h.getVector()) {
//            img.drawLine(x, img.getHeight(), x,
//                    img.getHeight() - (int) (d / max * img.getHeight()),
//                    (int) lineWidth, colour);
//            x += lineWidth;
//        }
//    }
//
//    @Override
//    public void afterUpdate(VideoDisplay<MBFImage> vd) {
//
//    }
//
//    @Override
//    public void beforeUpdate(MBFImage frame) {
//        plotHisto(frame, frame.getBand(0), RGBColour.RED);
//        plotHisto(frame, frame.getBand(1), RGBColour.GREEN);
//        plotHisto(frame, frame.getBand(2), RGBColour.BLUE);
//    }
//
//    public static void main(String[] args) {
//        new histo();
//    }
}
