
public class LibraryHub {

    public static void main(String[] args) {
        // Reading data from files
        Book[] books = ReadFromFile.readBooks("src/init/books.in");
        Author[] authors = ReadFromFile.readAuthors("src/init/authors.in");
        Country[] countries = ReadFromFile.readCountries("src/init/countries.in");
        EditorialGroup[] eGroups = ReadFromFile.readEditorials("src/init/editorial-groups.in");
        Language[] languages = ReadFromFile.readLanguages("src/init/languages.in");
        PublishingBrand[] pBrands = ReadFromFile.readPublishingBrands("src/init/publishing-brands.in");
        PublishingRetailer[] pRetailers = ReadFromFile.readPublishingRetailers("src/init/publishing-retailers.in");

        // Reading connections from files
        EstablishConnections.connectTwoEntities("src/init/books-authors.in", books, authors, 0);
        EstablishConnections.connectTwoEntities("src/init/editorial-groups-books.in", eGroups, books, 1);
        EstablishConnections.connectTwoEntities("src/init/publishing-brands-books.in", pBrands, books, 2);
        EstablishConnections.connectTwoEntities("src/init/publishing-retailers-books.in", pRetailers, books, 3);
        EstablishConnections.connectTwoEntities("src/init/publishing-retailers-countries.in", pRetailers, countries, 4);
        EstablishConnections.connectTwoEntities("src/init/publishing-retailers-editorial-groups.in", pRetailers, eGroups, 5);
        EstablishConnections.connectTwoEntities("src/init/publishing-retailers-publishing-brands.in", pRetailers, pBrands, 6);

        Administration library = new Administration(pRetailers, languages);

        /**
         * Tests for methods!
         */

        // Tests for GetBooksFromRetailerID
        TestsWriter.writeTestGetBooks(library, 1);
        TestsWriter.writeTestGetBooks(library, 11);
        TestsWriter.writeTestGetBooks(library, 12);
        TestsWriter.writeTestGetBooks(library, 13);
        TestsWriter.writeTestGetBooks(library, 14);

        // Tests for GetLanguagesForRetailerID
        TestsWriter.writeTestGetLanguages(library, 24);
        TestsWriter.writeTestGetLanguages(library, 25);
        TestsWriter.writeTestGetLanguages(library, 26);
        TestsWriter.writeTestGetLanguages(library, 27);
        TestsWriter.writeTestGetLanguages(library, 28);

        // Tests for GetCountriesForBookID
        TestsWriter.writeTestGetCountries(library, 204);
        TestsWriter.writeTestGetCountries(library, 224);
        TestsWriter.writeTestGetCountries(library, 262);
        TestsWriter.writeTestGetCountries(library, 275);
        TestsWriter.writeTestGetCountries(library, 350);

        // Tests for GetCommonBooks
        TestsWriter.writeTestGetCommonBooks(library,1,2);
        TestsWriter.writeTestGetCommonBooks(library,1,3);
        TestsWriter.writeTestGetCommonBooks(library,1,4);
        TestsWriter.writeTestGetCommonBooks(library,1,5);
        TestsWriter.writeTestGetCommonBooks(library,1,1);

        // Tests for GetAllBooks
        TestsWriter.writeTestGetAllBooks(library, 1, 2);
        TestsWriter.writeTestGetAllBooks(library, 1, 3);
        TestsWriter.writeTestGetAllBooks(library, 1, 4);
        TestsWriter.writeTestGetAllBooks(library, 1, 5);
        TestsWriter.writeTestGetAllBooks(library, 1, 1);
    }
}
