import SwiftUI
import shared
import UIKit

struct AppView : UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> some UIViewController {
        MainViewController()
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		AppView()
	}
}
