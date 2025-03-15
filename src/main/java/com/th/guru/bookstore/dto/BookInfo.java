package com.th.guru.bookstore.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class BookInfo {
    private ArrayList<Item> items;

    public String getTitle() {
        return items.getFirst().volumeInfo.title;
    }

    public Set<String> getAuthors() {
        return items.getFirst().volumeInfo.authors;
    }

    public String getPublisher() {
        return items.getFirst().volumeInfo.publisher;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public String getIsbn(){
        return items
                .getFirst()
                .volumeInfo
                .industryIdentifiers
                .stream()
                .filter(c -> Objects.equals(c.type, "ISBN_13"))
                .toList().getFirst().identifier;
    }

    @Override
    public String toString() {
        if (items == null || items.isEmpty()) {
            return "No books available.";
        }

        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            VolumeInfo vi = item.volumeInfo;
            sb.append("Title: ").append(vi.title).append("\n");
            sb.append("Authors: ").append(vi.authors != null ? String.join(", ", vi.authors) : "N/A").append("\n");
            sb.append("Publisher: ").append(vi.publisher != null ? vi.publisher : "N/A").append("\n");
            sb.append("-------------------------------\n");
        }
        return sb.toString();
    }

    private class VolumeInfo{
        public String title;
        public Set<String> authors;
        public String publisher;
        public List<IndustryIdentifier> industryIdentifiers;

        private String subtitle;
        private String publishedDate;
        private String description;
        private int pageCount;
        private String printType;
        private List<String> categories;
        private String maturityRating;
        private boolean allowAnonLogging;
        private String contentVersion;
        private String language;
        private String previewLink;
        private String infoLink;
        private String canonicalVolumeLink;
    }

    private class Item {
        public VolumeInfo volumeInfo;
    }

    private class IndustryIdentifier {
        public String type;
        public String identifier;
    }

}
