<script type="text/ng-template" id="affiliation-delete-ng2-template">
    <div class="row">
        <div class="col-md-12 col-xs-12 col-sm-12">
            <h3><@orcid.msg 'manage.deleteAffiliation.pleaseConfirm' /></h3>
            <p>{{deleteAffiliationObj.affiliationName.value}}</p>       
            <button id="confirm_delete_affiliation" class="btn btn-danger" (click)="deleteAffiliation()">
                <@orcid.msg 'freemarker.btnDelete' />
            </button>
            <button class="btn btn-white-no-border cancel-right" (click)="cancelEdit()"><@orcid.msg 'freemarker.btncancel' /></button>
        </div>
    </div>
</script>

<script type="text/ng-template" id="delete-funding-modal">
    <div class="row">
        <div class="col-md-12 col-xs-12 col-sm-12">
            <h3><@orcid.msg 'manage.deleteFunding.pleaseConfirm' /></h3>
            <p>{{fixedTitle}}</p>       
            <button id="confirm-delete-funding" class="btn btn-danger" (click)="deleteFundingByPut(deletePutCode, deleteGroup)">
                <@orcid.msg 'freemarker.btnDelete' />
            </div>
            <button class="btn btn-white-no-border cancel-right" (click)="closeModal()"><@orcid.msg 'freemarker.btncancel' /></button>
        </div>
    </div>
</script>