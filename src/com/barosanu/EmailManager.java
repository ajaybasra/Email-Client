package com.barosanu;

import com.barosanu.controller.services.FetchFoldersService;
import com.barosanu.controller.services.UpdateFoldersService;
import com.barosanu.model.EmailAccount;
import com.barosanu.model.EmailTreeItem;
import javafx.scene.control.TreeItem;

import javax.mail.Folder;
import java.util.ArrayList;
import java.util.List;

public class EmailManager {

    private UpdateFoldersService updateFoldersService;
    //Folder handling
    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<String>("");

    public EmailTreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }

    private List<Folder> folderList = new ArrayList<Folder>();
    public List<Folder> getFolderList() {
        return this.folderList;
    }

    public EmailManager() {
        updateFoldersService = new UpdateFoldersService(folderList);
        updateFoldersService.start();
    }

    public void addEmailAccount(EmailAccount emailAccount){
        EmailTreeItem<String> treeItem = new EmailTreeItem<String>(emailAccount.getAddress());
        FetchFoldersService fetchFoldersService = new FetchFoldersService(emailAccount.getStore(), treeItem, folderList);
         fetchFoldersService.start();
        foldersRoot.getChildren().add(treeItem);
    }
}
