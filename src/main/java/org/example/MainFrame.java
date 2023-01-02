package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class MainFrame extends JFrame implements ActionListener {
    private static final int x0 = 300;
    private static final int y0 = 200;
    private static final int width = 800;
    private static final int height = 600;
    private Map<String, myMenuItem> mediaMenuHashMap;
    private Map<String, myMenuItem> playbackMenuHashMap;
    private Map<String, myMenuItem> audioMenuHashMap;
    private Map<String, myMenuItem> videoMenuHashMap;
    private Map<String, myMenuItem> subtitleMenuHashMap;
    private Map<String, myMenuItem> toolsMenuHashMap;
    private Map<String, myMenuItem> viewMenuHashMap;

    public MainFrame() {
        JMenu mediaMenu = new JMenu("Media");
        // List for JMenuItem init
        ActionListener listener = this;
        mediaMenuHashMap = new LinkedHashMap<>() {{
            // syntax: param 1 = key, second param = myMenuItem constructor params
            // NB: HashMap is practical as we'll need to retrieve the source event in
            // ActionListener below!
            put("OpenFile", new myMenuItem("Open File...", "/folder_mini.png", listener, "ctrl O"));
            put("OpenMultipleFile", new myMenuItem("Open Multiple File...", "", listener, "ctrl M"));
            put("OpenFolder", new myMenuItem("Open Folder...", "", listener, "ctrl F"));
            put("OpenDisc", new myMenuItem("Open Disc...", "", listener, "ctrl D"));
            put("OpenNetworkStream", new myMenuItem("Open Network Stream...", "", listener, "ctrl N"));
            put("OpenCaptureDevice", new myMenuItem("Open Capture Device...", "", listener, "ctrl C"));
            put("OpenRecentMedia", new myMenuItem("Open Recent Media", "", listener, "ctrl V"));
            put("SavePlaylist", new myMenuItem("Save Playlist to File...", "", listener, "ctrl Y"));
            put("ConvertSave", new myMenuItem("Convert/Save...", "", listener, "ctrl R"));
            put("Stream", new myMenuItem("Stream...", "", listener, "ctrl S"));
            put("QuitProgram", new myMenuItem("Quit", "", listener, "ctrl Q"));
        }};

        // Add all resources in Media Menu
        for (Map.Entry<String, myMenuItem> entry : mediaMenuHashMap.entrySet()) {
            myMenuItem menuEntry = entry.getValue();
            JMenuItem jmenuItem = new JMenuItem(menuEntry.getTitle());
            // needed inside action listener
            menuEntry.setJMenuItem(jmenuItem);
            jmenuItem.setAccelerator(KeyStroke.getKeyStroke(menuEntry.getAccelerator()));
            try {
                jmenuItem.setIcon(new ImageIcon(getClass().getResource(menuEntry.getIconPath())));
            } catch (Exception e) {

            }
            jmenuItem.addActionListener(menuEntry.getActionListener());
            mediaMenu.add(jmenuItem);
        }

        // Build Playback Menu
        JMenu playbackMenu = new JMenu("Playback");
        playbackMenuHashMap = new LinkedHashMap<String, myMenuItem>() {{
            // syntax: param 1 = key, second param = myMenuItem constructor params
            // NB: HashMap is practical as we'll need to retrieve the source event in
            // ActionListener below!
            put("Title", new myMenuItem("Title", "", listener, ""));
            put("Chapter", new myMenuItem("Chapter", "", listener, ""));
            put("Program", new myMenuItem("Program", "", listener, ""));
            put("CustomBookmark", new myMenuItem("Custom Bookmark", "", listener, ""));
            put("Renderer", new myMenuItem("Renderer", "", listener, ""));
            put("Speed", new myMenuItem("Speed", "", listener, ""));
            put("JumpForward", new myMenuItem("Jump Forward", "", listener, ""));
            put("JumpBackward", new myMenuItem("Jump Backward", "", listener, ""));
            put("JumpToSpecific", new myMenuItem("Jump To Specific Time", "", listener, "ctrl T"));
            put("Play", new myMenuItem("Play", "/play_icon.png", listener, ""));
            put("Stop", new myMenuItem("Stop", "/stop_icon.png", listener, ""));
            put("Previous", new myMenuItem("Previous", "/previous_icon.png", listener, ""));
            put("Next", new myMenuItem("Next", "/next_icon.png", listener, ""));
            put("Record", new myMenuItem("Record", "/record_icon.png", listener, ""));
        }};

        // Add all resources in Media Menu
        for (Map.Entry<String, myMenuItem> entry : playbackMenuHashMap.entrySet()) {
            myMenuItem menuEntry = entry.getValue();
            JMenuItem jmenuItem = new JMenuItem(menuEntry.getTitle());
            // needed inside action listener
            menuEntry.setJMenuItem(jmenuItem);
            jmenuItem.setAccelerator(KeyStroke.getKeyStroke(menuEntry.getAccelerator()));
            try {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(menuEntry.getIconPath())));
                icon = new ImageIcon(icon.getImage().getScaledInstance(20, 20, icon.getImage().SCALE_DEFAULT));
                jmenuItem.setIcon(icon);
            } catch (Exception e) {

            }
            jmenuItem.addActionListener(menuEntry.getActionListener());
            // Add in the playback menu
            playbackMenu.add(jmenuItem);
        }

        ////////////////////////////////////
        // Build audio Menu
        JMenu audioMenu = new JMenu("Audio");
        audioMenuHashMap = new LinkedHashMap<String, myMenuItem>() {{
            // syntax: param 1 = key, second param = myMenuItem constructor params
            // NB: HashMap is practical as we'll need to retrieve the source event in
            // ActionListener below!
            put("AudioTrack", new myMenuItem("Audio Track", "", listener, ""));
            put("AudioDevice", new myMenuItem("Audio Device", "", listener, ""));
            put("StereoMode", new myMenuItem("Stereo Mode", "", listener, ""));
            put("Visualizations", new myMenuItem("Visualizations", "", listener, ""));
            put("IncreaseSound", new myMenuItem("Increase Volume", "", listener, ""));
            put("DecreaseSound", new myMenuItem("Decrease Volume", "", listener, ""));
            put("Mute", new myMenuItem("Mute", "", listener, ""));
        }};

        // Add all resources in Media Menu
        for (Map.Entry<String, myMenuItem> entry : audioMenuHashMap.entrySet()) {
            myMenuItem menuEntry = entry.getValue();
            JMenuItem jmenuItem = new JMenuItem(menuEntry.getTitle());
            // needed inside action listener
            menuEntry.setJMenuItem(jmenuItem);
            jmenuItem.setAccelerator(KeyStroke.getKeyStroke(menuEntry.getAccelerator()));
            try {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(menuEntry.getIconPath())));
                icon = new ImageIcon(icon.getImage().getScaledInstance(20, 20, icon.getImage().SCALE_DEFAULT));
                jmenuItem.setIcon(icon);
            } catch (Exception e) {

            }
            jmenuItem.addActionListener(menuEntry.getActionListener());
            // Add in the audio menu
            audioMenu.add(jmenuItem);
        }

        ////////////////////////////////////
        // Build Video Menu
        JMenu videoMenu = new JMenu("Video");
        videoMenuHashMap = new LinkedHashMap<String, myMenuItem>() {{
            // syntax: param 1 = key, second param = myMenuItem constructor params
            // NB: HashMap is practical as we'll need to retrieve the source event in
            // ActionListener below!
            put("videoTrack", new myMenuItem("video Track", "", listener, ""));
            put("FullScreen", new myMenuItem("Full Screen", "", listener, ""));
            put("Zoom", new myMenuItem("Zoom", "", listener, ""));
            put("AspectRatio", new myMenuItem("Aspect Ratio", "", listener, ""));
            put("Crop", new myMenuItem("Crop", "", listener, ""));
            put("DeInterlace", new myMenuItem("DeInterlace", "", listener, ""));
            put("DeInterlaceMode", new myMenuItem("DeInterlace Mode", "", listener, ""));
            put("Snapshot", new myMenuItem("Snapshot", "", listener, ""));
        }};

        // Add all resources in Media Menu
        for (Map.Entry<String, myMenuItem> entry : videoMenuHashMap.entrySet()) {
            myMenuItem menuEntry = entry.getValue();
            JMenuItem jmenuItem = new JMenuItem(menuEntry.getTitle());
            // needed inside action listener
            menuEntry.setJMenuItem(jmenuItem);
            jmenuItem.setAccelerator(KeyStroke.getKeyStroke(menuEntry.getAccelerator()));
            try {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(menuEntry.getIconPath())));
                icon = new ImageIcon(icon.getImage().getScaledInstance(20, 20, icon.getImage().SCALE_DEFAULT));
                jmenuItem.setIcon(icon);
            } catch (Exception e) {

            }
            jmenuItem.addActionListener(menuEntry.getActionListener());
            // Add in the video menu
            videoMenu.add(jmenuItem);
        }

        ////////////////////////////////////
        // Build subtitle Menu
        JMenu subtitleMenu = new JMenu("Subtitle");
        subtitleMenuHashMap = new LinkedHashMap<String, myMenuItem>() {{
            // syntax: param 1 = key, second param = myMenuItem constructor params
            // NB: HashMap is practical as we'll need to retrieve the source event in
            // ActionListener below!
            put("AddSubtitleTrack", new myMenuItem("Add Subtitle Track", "", listener, ""));
            put("SubTrack", new myMenuItem("Sub Track", "", listener, ""));
        }};

        // Add all resources in Media Menu
        for (Map.Entry<String, myMenuItem> entry : subtitleMenuHashMap.entrySet()) {
            myMenuItem menuEntry = entry.getValue();
            JMenuItem jmenuItem = new JMenuItem(menuEntry.getTitle());
            // needed inside action listener
            menuEntry.setJMenuItem(jmenuItem);
            jmenuItem.setAccelerator(KeyStroke.getKeyStroke(menuEntry.getAccelerator()));
            try {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(menuEntry.getIconPath())));
                icon = new ImageIcon(icon.getImage().getScaledInstance(20, 20, icon.getImage().SCALE_DEFAULT));
                jmenuItem.setIcon(icon);
            } catch (Exception e) {

            }
            jmenuItem.addActionListener(menuEntry.getActionListener());
            // Add in the video menu
            subtitleMenu.add(jmenuItem);
        }

        ////////////////////////////////////
        // Build tools Menu
        JMenu toolsMenu = new JMenu("Tools");
        toolsMenuHashMap = new LinkedHashMap<String, myMenuItem>() {{
            // syntax: param 1 = key, second param = myMenuItem constructor params
            // NB: HashMap is practical as we'll need to retrieve the source event in
            // ActionListener below!
            put("EffectAndFilters", new myMenuItem("Effect And Filters", "", listener, "ctrl E"));
            put("TrackSynchronization", new myMenuItem("Track Synchronization", "", listener, ""));
            put("MediaInformation", new myMenuItem("Media Information", "", listener, "ctrl I"));
            put("CodecInfomation", new myMenuItem("Codec Information", "", listener, "ctrl J"));
            put("VlmConfig", new myMenuItem("VLM Configuration", "", listener, "ctrl W"));
            put("ProgramGuide", new myMenuItem("Program Guide", "", listener, ""));
            put("Messages", new myMenuItem("Messages", "", listener, "ctrl M"));
            put("PluginsAndExtensions", new myMenuItem("Plugins And Extensions", "", listener, ""));
            put("CustomInterface", new myMenuItem("Custom Interface...", "", listener, ""));
            put("Preferences", new myMenuItem("Preferences", "", listener, "ctrl P"));
        }};

        // Add all resources in Media Menu
        for (Map.Entry<String, myMenuItem> entry : toolsMenuHashMap.entrySet()) {
            myMenuItem menuEntry = entry.getValue();
            JMenuItem jmenuItem = new JMenuItem(menuEntry.getTitle());
            // needed inside action listener
            menuEntry.setJMenuItem(jmenuItem);
            jmenuItem.setAccelerator(KeyStroke.getKeyStroke(menuEntry.getAccelerator()));
            try {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(menuEntry.getIconPath())));
                icon = new ImageIcon(icon.getImage().getScaledInstance(20, 20, icon.getImage().SCALE_DEFAULT));
                jmenuItem.setIcon(icon);
            } catch (Exception e) {

            }
            jmenuItem.addActionListener(menuEntry.getActionListener());
            // Add in the video menu
            toolsMenu.add(jmenuItem);
        }

        ////////////////////////////////////////////
        // Build view Menu
        JMenu viewMenu = new JMenu("View");
        viewMenuHashMap = new LinkedHashMap<String, myMenuItem>() {{
            // syntax: param 1 = key, second param = myMenuItem constructor params
            // NB: HashMap is practical as we'll need to retrieve the source event in
            // ActionListener below!
            put("Playlist", new myMenuItem("Playlist", "", listener, "ctrl L"));
            put("DockedPlaylist", new myMenuItem("Docked Playlist", "", listener, ""));
            put("PlaylistViewMode", new myMenuItem("Playlist View Mode", "", listener, ""));
            put("AlwaysOnTop", new myMenuItem("Always On Top", "", listener, "ctrl J"));
            put("MinimalInterface", new myMenuItem("Minimal Interface", "", listener, "ctrl H"));
            put("FullscreenInterface", new myMenuItem("Fullscreen Interface", "", listener, "F11"));
            put("AdvancedControl", new myMenuItem("Advanced Control", "", listener, ""));
            put("StatusBar", new myMenuItem("Status Bar", "", listener, ""));
            put("AddInterface", new myMenuItem("Add Interface...", "", listener, ""));
            put("SubstMenu", new myMenuItem("VL Sub", "", listener, ""));
        }};

        // Add all resources in Media Menu
        for (Map.Entry<String, myMenuItem> entry : viewMenuHashMap.entrySet()) {
            myMenuItem menuEntry = entry.getValue();
            JMenuItem jmenuItem = new JMenuItem(menuEntry.getTitle());
            // needed inside action listener
            menuEntry.setJMenuItem(jmenuItem);
            jmenuItem.setAccelerator(KeyStroke.getKeyStroke(menuEntry.getAccelerator()));
            try {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(menuEntry.getIconPath())));
                icon = new ImageIcon(icon.getImage().getScaledInstance(20, 20, icon.getImage().SCALE_DEFAULT));
                jmenuItem.setIcon(icon);
            } catch (Exception e) {

            }
            jmenuItem.addActionListener(menuEntry.getActionListener());
            // Add in the video menu
            viewMenu.add(jmenuItem);
        }

        // Build Help Menu
        JMenu helpMenu = new JMenu("Help");

        JMenuBar jmb = new JMenuBar();

        jmb.add(mediaMenu);
        jmb.add(playbackMenu);
        jmb.add(audioMenu);
        jmb.add(videoMenu);
        jmb.add(subtitleMenu);
        jmb.add(toolsMenu);
        jmb.add(viewMenu);
        jmb.add(helpMenu);

        this.setJMenuBar(jmb);

        this.setBounds(x0, y0, width, height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mediaMenuHashMap.get("QuitProgram").getJmenuItem()) {
            System.exit(0);
        }
    }
}
