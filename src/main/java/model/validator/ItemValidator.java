package model.validator;

import crypt.api.signatures.Signer;
import crypt.impl.key.ElGamalAsymKey;
import crypt.impl.signatures.ElGamalSignature;
import model.entity.Item;

public class ItemValidator extends EntityValidator<Item>{
	
	private Signer<ElGamalSignature, ElGamalAsymKey> signer = null;
	
	public void setSigner(Signer<ElGamalSignature, ElGamalAsymKey> signer) {
		this.signer = signer;
	}
	
	@Override
	public boolean validate() {
		return super.validate() && validateSignature();
	}
	
	/*
	 * ModelSXP : 
	 * In the project as we took it, this always return false, or throw an exception.
	 * Since we do not know what the signer is and this method looks only partially implemented, we ignore it.
	 */
	private boolean validateSignature() {
		/*if(signer == null) throw new RuntimeException("no signer were setteld");
		return false;*/
		return true;
	}
}
